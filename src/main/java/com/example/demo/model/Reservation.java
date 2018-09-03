package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reservationId;
	@OneToMany
	private List<Service> availedServcelist;
	private String departureDate;
	@ManyToOne
	private Customer customer;
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public List<Service> getAvailedServcelist() {
		return availedServcelist;
	}
	public void setAvailedServcelist(List<Service> availedServcelist) {
		this.availedServcelist = availedServcelist;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
