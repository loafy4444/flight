package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.pojo.Flight;
import com.cooksys.service.FlightService;

@RestController
@RequestMapping("flights")
@CrossOrigin(origins = "*")
public class FlightsController {
	
	private final FlightService service;
		
	@Autowired
	public FlightsController (FlightService service){
		this.service = service;
	}
	
	@RequestMapping
	public List<Flight> getFlightList(){
		return this.service.getDailyFlightList();
	}
	
	// Retrieves connecting flights in postman but breaks the front end when booking itineraries.
	@RequestMapping(value = "/{origin}/{destination}", method = RequestMethod.GET)
	public List<List<Flight>> connectingFlights(@PathVariable String origin, @PathVariable String destination){
		return this.service.getConnectingFlights(origin, destination);
	}

}
