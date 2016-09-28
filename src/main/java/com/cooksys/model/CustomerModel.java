package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.entity.Customer;

public class CustomerModel {
	
	private Long id;
	
	private String username;
	
	private String email;
	
	private List<ItineraryModel> itineraries;
	
	public CustomerModel(Customer customer){
		super();
		this.id = customer.getId();
		this.username = customer.getUsername();
		this.email = customer.getEmail();
		this.itineraries = ItineraryModel.list(customer.getItineraries());
	}
	
	public static CustomerModel response(Customer customer){
		return new CustomerModel(customer);
	}
	
	public static List<CustomerModel> list(List<Customer> customers){
		List<CustomerModel> result = new ArrayList<>();
		for(Customer customer: customers){
			result.add(new CustomerModel(customer));
		}
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ItineraryModel> getItineraries() {
		return itineraries;
	}

	public void setItineraries(List<ItineraryModel> itineraries) {
		this.itineraries = itineraries;
	}
	
}
