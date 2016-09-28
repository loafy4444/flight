package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.entity.Customer;
import com.cooksys.entity.DBFlight;
import com.cooksys.entity.Itinerary;

public class ItineraryModel {
	
	private Long id;
	
	private CustomerBase customer;
	
	private List<DBFlight> flight;
	
	public ItineraryModel(Itinerary itinerary){
		super();
		this.id = itinerary.getId();
		this.customer = CustomerBase.response(itinerary.getCustomer());
		this.flight = itinerary.getFlights();
	}
	
	public static ItineraryModel response(Itinerary itinerary){
		return new ItineraryModel(itinerary);
	}
	
	public static List<ItineraryModel> list(List<Itinerary> itineraries){
		List<ItineraryModel> result = new ArrayList<>();
		for(Itinerary itinerary: itineraries){
			result.add(new ItineraryModel(itinerary));
		}
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerBase getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = CustomerBase.response(customer);
	}

	public List<DBFlight> getFlight() {
		return flight;
	}

	public void setFlight(List<DBFlight> flight) {
		this.flight = flight;
	}
	
}
