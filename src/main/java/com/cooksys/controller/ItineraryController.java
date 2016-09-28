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
import com.cooksys.model.ItineraryBase;
import com.cooksys.model.ItineraryModel;
import com.cooksys.service.DBFlightService;
import com.cooksys.service.ItineraryService;


@RestController
@RequestMapping("itinerary")
@CrossOrigin(origins = "*")
public class ItineraryController {
	
	private final ItineraryService service;
			
	@Autowired
	public ItineraryController (ItineraryService service, DBFlightService dbflightService){
		this.service = service;
	}
	
	@RequestMapping
	public List<ItineraryModel> index(){
		return this.service.index();
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<ItineraryBase> indexCust(@PathVariable Long id){
		return this.service.indexByCustId(id);
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.POST)
	public ItineraryModel createByIds(@PathVariable Long id, @RequestBody List<Long> flights){
		return this.service.createById(id, flights);
	}
	
	@RequestMapping(value = "/booking/{id}", method = RequestMethod.POST)
	public ItineraryModel createByFlights(@PathVariable Long id, @RequestBody List<DBFlight> flights){
		return this.service.createByFlights(id, flights);
	}
	
}
