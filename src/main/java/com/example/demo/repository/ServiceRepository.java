package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Service;

public interface ServiceRepository extends CrudRepository<Service, Integer> {

}
