package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Image;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.ImageRepository;
@Service
public class ImageService {

	private ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}
	
	public Image addImages(Image image) {
		return imageRepository.save(image);
	}
	
	public void deleteImages(Image image) {
		imageRepository.delete(image);
	}
	
	
}
