package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ServiceFee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serviceFeeId;
	private float amount;
	@ManyToOne
	private Service service;
	private String startDate;
	public int getServiceFeeId() {
		return serviceFeeId;
	}
	public void setServiceFeeId(int serviceFeeId) {
		this.serviceFeeId = serviceFeeId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	} 
	
	
}
