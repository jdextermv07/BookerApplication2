package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
public class TravelPackage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int travelpackageId;
	private String packageName;
	
	@OneToMany(mappedBy = "travelPackage")
	private List<Service> availableServiceList;
	
	@OneToMany(mappedBy = "travelPackage")
	private List<Image> images;
	
	private String description;
	
	
	public int getTravelpackageId() {
		return travelpackageId;
	}
	public void setTravelpackageId(int travelpackageId) {
		this.travelpackageId = travelpackageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public List<Service> getAvailableServiceList() {
		return availableServiceList;
	}
	public void setAvailableServiceList(List<Service> availableServiceList) {
		this.availableServiceList = availableServiceList;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
