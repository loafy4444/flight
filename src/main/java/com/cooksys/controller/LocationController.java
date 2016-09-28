package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Location;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("location")
@CrossOrigin(origins = "*")
public class LocationController {
	
	private LocationService service;

	@Autowired
	public LocationController(LocationService service){
		this.service = service;
	}
	
	@RequestMapping
	public List<Location> index(){
		return this.service.index();
	}

	@RequestMapping("/{id}")
	public Location read(@PathVariable long id){
		return this.service.read(id);
	}
	
	@RequestMapping("/name")
	public Location read(@RequestParam("name") String cityName){
		return this.service.read(cityName);
	}

}
