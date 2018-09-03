package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Feedback;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	private Customer cust;

	
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	// customers
	public List<Customer> findAllList(){
		Iterable<Customer> iterCust = customerRepository.findAll();
		List<Customer> listCustomer = new ArrayList<Customer>();
		for(Customer value:iterCust) {
			listCustomer.add(value);
		}	
		return listCustomer;
	}
	@Transactional
	public List<Customer> updateCustomerList(List<Customer> customerList) {
		List<Customer> listCustomer = new ArrayList<Customer>();
		for(Customer value:customerList) {
			Customer customerTemp = customerRepository.findById(value.getCustomerId()).get();
			if (value.getCustomerId() == customerTemp.getCustomerId()) {
				customerRepository.save(value);
				listCustomer.add(value);
			}
			else {
				System.out.println("Invalid");
			}
		}
		return listCustomer;
	}
	
	public List<Customer> addCustomerList(List<Customer> customerList) {
		List<Customer> listCustomer = new ArrayList<Customer>();
		for(Customer value:customerList) {
			customerRepository.save(value);
			listCustomer.add(value);
		}
		return listCustomer;
	}
	
	public void deleteCustomerList(int[] intArray) {
		for (int value : intArray) {
			customerRepository.delete(customerRepository.findById(value).get());
		}

	}


	
	// customer
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
	public Customer findById(int id) {
		return customerRepository.findById(id).get();
	}
	
	public Customer updateCustomer(Customer customer, int customerId) {
		customer.setCustomerId(customerId);
		return customerRepository.save(customer);
	}
	

	
	
	
	

	
	
}
