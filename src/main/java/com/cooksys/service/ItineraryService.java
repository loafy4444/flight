package com.cooksys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.DBFlight;
import com.cooksys.entity.Itinerary;
import com.cooksys.model.ItineraryBase;
import com.cooksys.model.ItineraryModel;
import com.cooksys.repository.CustomerRepository;
import com.cooksys.repository.DBFlightRepository;
import com.cooksys.repository.ItineraryRepository;

@Service
public class ItineraryService {

	private final ItineraryRepository repo;
	private final CustomerRepository custRepo;
	private final DBFlightRepository flightRepo;
	
	@Autowired
	public ItineraryService(ItineraryRepository repo, CustomerRepository custRepo,
			DBFlightRepository flightRepo){
		this.repo = repo;
		this.custRepo = custRepo;
		this.flightRepo = flightRepo;
	}
	
	public List<ItineraryModel> index(){
		return ItineraryModel.list(this.repo.findAll());
	}
	
	public List<ItineraryBase> indexByCustId(Long id){
		List<Itinerary> result = new ArrayList<>();
		result.addAll(this.custRepo.findById(id).getItineraries());
		return ItineraryBase.list(result);
	}
	
	public ItineraryModel createById(Long id, List<Long> flights){
		Itinerary itinerary = new Itinerary();
		List<DBFlight> flightsToSave = new ArrayList<>();
		for(Long fid: flights){
			flightsToSave.add(flightRepo.findById(fid));
		}
		itinerary.setCustomer(this.custRepo.findById(id));
		itinerary.setFlights(flightsToSave);	
		this.repo.saveAndFlush(itinerary);
		return ItineraryModel.response(itinerary);
	}
	
	
	public ItineraryModel createByFlights(Long id, List<DBFlight> flights){
		Itinerary itinerary = new Itinerary();
		List<DBFlight> flightsToSave = new ArrayList<>();
		for(DBFlight flight: flights){
			DBFlight temp = new DBFlight();
			// Vain attempt to work around disappering destination at posting.
			temp.setDestination(flight.getDestination());
			temp.setOrigin(flight.getOrigin());
			temp.setFlightTime(flight.getFlightTime());
			temp.setOffset(flight.getOffset());
			
			flightRepo.save(temp);
			flightsToSave.add(temp);
		}
		itinerary.setCustomer(this.custRepo.findById(id));
		itinerary.setFlights(flightsToSave);	
		this.repo.saveAndFlush(itinerary);
		return ItineraryModel.response(itinerary);
	}
}
