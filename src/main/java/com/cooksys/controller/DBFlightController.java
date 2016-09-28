package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.DBFlight;
import com.cooksys.service.DBFlightService;

@RestController
@RequestMapping("dbflight")
@CrossOrigin(origins = "*")
public class DBFlightController {
	
	private final DBFlightService service;
	
	@Autowired
	public DBFlightController(DBFlightService service){
		this.service = service;
	}
	
	@RequestMapping
	public List<DBFlight> index(){
		return this.service.index();
	}
	
	@RequestMapping(value = "/origin/{name}", method = RequestMethod.GET)
	public List<DBFlight> indexByOrigin(@PathVariable String name){
		return this.service.indexByOrigin(name);
	}
	
	@RequestMapping(value = "/destination/{name}", method = RequestMethod.GET)
	public List<DBFlight> indexByDestination(@PathVariable String name){
		return this.service.indexByDestination(name);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DBFlight read(@PathVariable Long id){
		return this.service.read(id);
	}
	
	// Issues with boooking more than one flights sometimes.
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public DBFlight create(@RequestBody DBFlight flight){
		return this.service.create(flight);
	}
}
