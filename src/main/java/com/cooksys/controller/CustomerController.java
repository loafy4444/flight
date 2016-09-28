package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Customer;
import com.cooksys.model.CustomerBase;
import com.cooksys.model.CustomerModel;
import com.cooksys.model.CustomerVerifyModel;
import com.cooksys.service.CustomerService;

@RestController
@RequestMapping("customer")
@CrossOrigin(origins = "*")
public class CustomerController {
	
	private final CustomerService service;
	
	@Autowired
	public CustomerController(CustomerService service){
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<CustomerModel> index(){
		return this.service.index();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CustomerModel read(@PathVariable long id){
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public CustomerModel read(@RequestParam("name") String username){
		return this.service.read(username);
	}
	
	@RequestMapping(value = "/validate/name", method = RequestMethod.GET)
	public CustomerVerifyModel validate(@RequestParam("name") String username){
		return this.service.validate(username);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CustomerBase create(@RequestBody Customer customer){
		return this.service.create(customer);
	}
	
	
}
