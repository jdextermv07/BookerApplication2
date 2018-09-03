package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Service;
import com.example.demo.model.TravelPackage;
import com.example.demo.service.ServiceTravelPackageService;

@RestController
@RequestMapping("/travel-packages/{id}/services")
public class ServiceController {
	
	ServiceTravelPackageService serviceTravelPackageService;

	public ServiceController(ServiceTravelPackageService serviceTravelPackageService) {
		super();
		this.serviceTravelPackageService = serviceTravelPackageService;
	}
	
	// travel-packages-services
	@GetMapping
	public List<Service> findAllServices(@PathVariable ("id") int travelPackageId){
		return serviceTravelPackageService.findAllServices(travelPackageId);
	}
	
	@PostMapping
	public List<Service> addServices(@PathVariable ("id") int travelPackageId, @RequestBody List<Service> service){
		return serviceTravelPackageService.addServices(travelPackageId, service);
	}
	
	@PutMapping
	public List<Service> updateServices(@PathVariable ("id") int travelPackageId, @RequestBody List<Service> service){
		return serviceTravelPackageService.updateServices(travelPackageId, service);
	}
	
	@DeleteMapping
	public void deleteServices(@PathVariable ("id") int travelPackageId) {
		serviceTravelPackageService.deleteServices(travelPackageId);
	}
	
	// travel-packages-service
	
	@GetMapping("/{serviceId}")
	public Service findServiceById(@PathVariable ("id") int travelPackageId, @PathVariable ("serviceId") int serviceId) {
		return serviceTravelPackageService.getService(serviceId);
		
	} 
	
	@PutMapping("/{serviceId}")
	public Service updateService(@PathVariable ("id") int travelPackageId, @PathVariable ("serviceId") int serviceId
			, @RequestBody Service service) {
		return serviceTravelPackageService.updateService(serviceId, service);
	}
	
	@DeleteMapping("/{serviceId}")
	public void deleteService(@PathVariable ("id") int travelPackageId, @PathVariable ("serviceId") int serviceId) {
		
	}
	
	
	
	
	
	
	

	
}
