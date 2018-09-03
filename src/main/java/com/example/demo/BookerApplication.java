package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.demo.controller","com.example.demo", 
		"com.example.demo.repository", "com.example.demo.model", "com.example.demo.service"})
public class BookerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookerApplication.class, args);
	}
}
