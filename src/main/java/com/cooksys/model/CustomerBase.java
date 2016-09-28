package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.entity.Customer;


public class CustomerBase {

	private Long id;
	
	private String username;
	
	private String email;
	
	public CustomerBase(Customer customer){
		super();
		this.id = customer.getId();
		this.username = customer.getUsername();
		this.email = customer.getEmail();
	}
	
	public static CustomerBase response(Customer customer){
		return new CustomerBase(customer);
	}
	
	public static List<CustomerBase> list(List<Customer> customers){
		List<CustomerBase> result = new ArrayList<>();
		for(Customer customer: customers){
			result.add(new CustomerBase(customer));
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
	
}
