package com.example.demo.controller;

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

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	// customers
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.findAllList();
	}
	
	@PostMapping
	public List<Customer> saveCustomer(@RequestBody List<Customer> customer) {
		return customerService.addCustomerList(customer);
	}
	
	@PutMapping
	public List<Customer> updateCustomer(@RequestBody List<Customer> customer) {
		return customerService.updateCustomerList(customer);
	}
	
	@DeleteMapping
	public void deleteCustomer(@RequestParam("customerIdList") int[] intArray) {
		customerService.deleteCustomerList(intArray);
	}
	
	// customer
	@GetMapping("/{id}")
	public Customer findById (@PathVariable ("id") int customerId) {
		return customerService.findById(customerId);
	} 
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable ("id") int customerId) {
		return customerService.updateCustomer (customer, customerId);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable ("id") int customerId) {
		customerService.deleteCustomer(customerService.findById(customerId));
	}
	
	
	
	
	

}
