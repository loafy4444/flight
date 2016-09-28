package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Location;
import com.cooksys.repository.LocationRepository;

@Service
public class LocationService {
	
	private final LocationRepository repo;
	
	@Autowired
	public LocationService(LocationRepository repo){
		this.repo = repo;
	}
		
	public List<Location> index(){
		return this.repo.findAll();
	}

	public Location read(long id){
		return this.repo.findById(id);
	}
	
	public Location read(String name){
		return this.repo.findByCity(name);
	}
}
