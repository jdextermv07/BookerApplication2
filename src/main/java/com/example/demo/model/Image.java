package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
public class Image {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int imageId;
	private String description;
	private String imageUrl;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name= "travelPackageid")
	private TravelPackage travelPackage;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "serviceId")
	private Service service;
	
	
	public TravelPackage getTravelPackage() {
		return travelPackage;
	}
	public void setTravelPackage(TravelPackage travelPackage) {
		this.travelPackage = travelPackage;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
