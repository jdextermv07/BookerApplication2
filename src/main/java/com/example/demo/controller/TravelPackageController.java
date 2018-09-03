package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Service;
import com.example.demo.model.TravelPackage;
import com.example.demo.service.ServiceService;
import com.example.demo.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {

	TravelPackageService travelPackageService;


	public TravelPackageController(TravelPackageService travelPackageService) {
		super();
		this.travelPackageService = travelPackageService;
	}
	
	// travel-packages
	@GetMapping
	public List<TravelPackage> getAllTravelPackage(){
		return travelPackageService.findAllList();
	}
	
	@PostMapping
	public List<TravelPackage> saveTravelPackage(@RequestBody List<TravelPackage> travelPackage) {
		return travelPackageService.addTravelPackageList(travelPackage);
	}
	
	@PutMapping
	public List<TravelPackage> updateTravelPackage(@RequestBody List<TravelPackage> travelPackage){
		return travelPackageService.updateTravelPackageList(travelPackage);
	}
	
	@DeleteMapping
	public void deleteTravelPackage(@RequestParam ("travelPackageIdList")int[] intArray){
		travelPackageService.deleteTravelPackageList(intArray);
	}
	
	
	
	// travel-package
	@GetMapping("/{id}")
	public TravelPackage findById (@PathVariable ("id") int travelPackageId) {
		return travelPackageService.findById(travelPackageId);
	} 
	
	@PutMapping("/{id}")
	public TravelPackage updateTravelPackage(@RequestBody TravelPackage travelPackage, @PathVariable ("id") int travelPackageId) {
		return travelPackageService.updateTravelPackage (travelPackage, travelPackageId);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTravelPackage(@PathVariable ("id") int customerId) {
		travelPackageService.deleteTravelPackage(travelPackageService.findById(customerId));
	}
	
	
	
	
	
	
	
	

}
