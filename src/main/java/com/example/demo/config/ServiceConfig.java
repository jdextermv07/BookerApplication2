package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ImageService;
import com.example.demo.service.ServiceTravelPackageService;
import com.example.demo.service.TravelPackageService;

@Configuration
public class ServiceConfig {

	@Bean
	public CustomerService customerService(CustomerRepository customerRepository) {
		return new CustomerService(customerRepository);
	}
	@Bean
	public ServiceTravelPackageService ServiceTravelPackageService(ServiceRepository serviceRepository, TravelPackageService travelPackageService, ImageService imageService) {
		return new ServiceTravelPackageService(serviceRepository, travelPackageService, imageService);
	}
	

}
