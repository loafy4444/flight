package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Customer;
import com.cooksys.model.CustomerBase;
import com.cooksys.model.CustomerModel;
import com.cooksys.model.CustomerVerifyModel;
import com.cooksys.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository repo;
	
	@Autowired
	public CustomerService(CustomerRepository repo){
		this.repo = repo;
	}
	
	public List<CustomerModel> index(){
		return CustomerModel.list(this.repo.findAll());
	}

	public CustomerModel read(long id){
		return CustomerModel.response(this.repo.findById(id));
	}
	
	public CustomerModel read(String name){
		return CustomerModel.response(this.repo.findByUsername(name));
	}
	
	public CustomerVerifyModel validate(String name){
		return CustomerVerifyModel.response(this.repo.findByUsername(name));
	}
	
	public CustomerBase create(Customer customer){
		this.repo.save(customer);
		return CustomerBase.response(this.repo.findByUsername(customer.getUsername()));
	}
}
