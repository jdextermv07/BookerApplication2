package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Image;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.TravelPackageRepository;

@Service
public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;
	private ServiceService serviceService;
	private ImageService imageService;

	public TravelPackageService(TravelPackageRepository travelPackageRepository, ServiceService serviceService,
			ImageService imageService) {
		super();
		this.travelPackageRepository = travelPackageRepository;
		this.serviceService = serviceService;
		this.imageService = imageService;
	}

	// travel packages
	public List<TravelPackage> findAllList() {
		Iterable<TravelPackage> iterTravPack = travelPackageRepository.findAll();
		List<TravelPackage> listTravelPackage = new ArrayList<TravelPackage>();
		for (TravelPackage value : iterTravPack) {
			listTravelPackage.add(value);
		}
		return listTravelPackage;
	}

	@Transactional
	public List<TravelPackage> addTravelPackageList(List<TravelPackage> travelPackageList) {
		List<TravelPackage> listTravelPackage = new ArrayList<TravelPackage>();
		for (TravelPackage travelPackage : travelPackageList) {

			for (com.example.demo.model.Service service : travelPackage.getAvailableServiceList()) {
				service.setTravelPackage(travelPackage);
				serviceService.addServices(service);

				for (Image image : service.getImages()) {
					image.setService(service);
					imageService.addImages(image);
				}
				for (Image image1 : travelPackage.getImages()) {
					image1.setTravelPackage(travelPackage);
					imageService.addImages(image1);
				}
			}
			travelPackageRepository.save(travelPackage);
			listTravelPackage.add(travelPackage);
		}
		return listTravelPackage;
	}

	@Transactional
	public List<TravelPackage> updateTravelPackageList(List<TravelPackage> travelPackageList) {
		List<TravelPackage> listTravelPackage = new ArrayList<TravelPackage>();
		for (TravelPackage travelPackage : travelPackageList) {
			TravelPackage travPackTemp = travelPackageRepository.findById(travelPackage.getTravelpackageId()).get();
			if (travelPackage.getTravelpackageId() == travPackTemp.getTravelpackageId()) {
				for (com.example.demo.model.Service service : travelPackage.getAvailableServiceList()) {

					for (Image image : service.getImages()) {
						image.setService(service);
						imageService.addImages(image);
					}

					service.setTravelPackage(travelPackage);
					serviceService.addServices(service);
				}

				for (Image image1 : travelPackage.getImages()) {
					image1.setTravelPackage(travelPackage);
					imageService.addImages(image1);
				}
				travelPackageRepository.save(travelPackage);
				listTravelPackage.add(travelPackage);
			} else {
				System.out.println("Failed");
			}
		}
		return listTravelPackage;
	}

	public void deleteTravelPackageList(int[] intArray) {
		for (int value : intArray) {
			TravelPackage travelPackTemp = travelPackageRepository.findById(value).get();
			for(com.example.demo.model.Service service : travelPackTemp.getAvailableServiceList()) {
				
				for (Image image : service.getImages()) {
					imageService.deleteImages(image);
				}
				for (Image image1 : travelPackTemp.getImages()) {
					imageService.deleteImages(image1);
				}
				serviceService.deleteServices(service);
			}
			travelPackageRepository.delete(travelPackTemp);
		}

	}

	// travel package travelPackageRepository.delete(

	public void deleteTravelPackage(TravelPackage travelPackage) {
		for(com.example.demo.model.Service service : travelPackage.getAvailableServiceList()) {
			
			for (Image image : service.getImages()) {
				imageService.deleteImages(image);
			}
			for (Image image1 : travelPackage.getImages()) {
				imageService.deleteImages(image1);
			}
			serviceService.deleteServices(service);
		}
		travelPackageRepository.delete(travelPackage);
	}

	public TravelPackage findById(int id) {
		return travelPackageRepository.findById(id).get();
	}

	public TravelPackage updateTravelPackage(TravelPackage travelPackage, int travelPackageId) {
		travelPackage.setTravelpackageId(travelPackageId);
		return travelPackageRepository.save(travelPackage);
	}
	
	

}
