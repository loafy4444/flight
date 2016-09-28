package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.entity.DBFlight;
import com.cooksys.entity.Itinerary;

public class ItineraryBase {
	
	private Long id;
	
	private List<DBFlight> flight;
	
	public ItineraryBase(Itinerary itinerary){
		super();
		this.id = itinerary.getId();
		this.flight = itinerary.getFlights();
	}
	
	public static ItineraryBase response(Itinerary itinerary){
		return new ItineraryBase(itinerary);
	}
	
	public static List<ItineraryBase> list(List<Itinerary> itineraries){
		List<ItineraryBase> result = new ArrayList<>();
		for(Itinerary itinerary: itineraries){
			result.add(new ItineraryBase(itinerary));
		}
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DBFlight> getFlight() {
		return flight;
	}

	public void setFlight(List<DBFlight> flight) {
		this.flight = flight;
	}

}
