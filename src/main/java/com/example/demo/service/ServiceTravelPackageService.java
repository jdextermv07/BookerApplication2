package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Image;
import com.example.demo.model.Service;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.ServiceRepository;

public class ServiceTravelPackageService {

	private ServiceRepository serviceRepository;
	private TravelPackageService travelPackageService;
	private ImageService imageService;

	public ServiceTravelPackageService(ServiceRepository serviceRepository, TravelPackageService travelPackageService,
			ImageService imageService) {
		super();
		this.serviceRepository = serviceRepository;
		this.travelPackageService = travelPackageService;
		this.imageService = imageService;
	}

	// travel-package-services
	public List<Service> findAllServices(int travelPackageId) {
		Iterable<Service> iterSer = travelPackageService.findById(travelPackageId).getAvailableServiceList();
		List<Service> listService = new ArrayList<Service>();
		for (Service value : iterSer) {
			listService.add(value);
		}
		return listService;
	}

	public List<Service> addServices(int travelPackageId, List<Service> serviceList) {
		Iterable<Service> iterSer = serviceList;
		List<Service> listService = new ArrayList<Service>();
		for (Service value : iterSer) {
			value.setTravelPackage(travelPackageService.findById(travelPackageId));
			serviceRepository.save(value);
			listService.add(value);
			for (Image image : value.getImages()) {
				image.setService(value);
				imageService.addImages(image);
			}
		}
		return listService;
	}

	public List<Service> updateServices(int travelPackageId, List<Service> serviceList) {
		for (Service service : serviceList) {
			if (!serviceRepository.findById(service.getServiceId()).isPresent()) {
				throw new RuntimeException("Service not existing");
			}
		}
		return (List<Service>) serviceRepository.saveAll(serviceList);
	}

	public void deleteServices(int travelPackageId) {
		List<Service> listService = travelPackageService.findById(travelPackageId).getAvailableServiceList();
		serviceRepository.deleteAll(listService);
	}

	// travel-packages-service

	public Service getService(int serviceId) {
		return serviceRepository.findById(serviceId).get();
	}

	public Service updateService(int serviceId, Service service) {
		if (!serviceRepository.findById(service.getServiceId()).isPresent()) {
			throw new RuntimeException("Service not existing");
		}
		service.setServiceId(serviceId);
		return serviceRepository.save(service);
	}
	
	public void deleteService(int serviceId) {
		serviceRepository.delete(serviceRepository.findById(serviceId).get());
	}

}
