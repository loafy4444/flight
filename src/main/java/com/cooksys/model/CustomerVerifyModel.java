package com.cooksys.model;

import com.cooksys.entity.Customer;

public class CustomerVerifyModel {

	private Long id;
	
	private String username;
	
	private String password;
	
	public CustomerVerifyModel(Customer customer){
		super();
		this.id = customer.getId();
		this.username = customer.getUsername();
		this.password = customer.getPassword();
	}
	
	public static CustomerVerifyModel response(Customer customer){
		return new CustomerVerifyModel(customer);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
