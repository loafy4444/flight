package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findById(Long id);
	
	Customer findByUsername(String name);

}
