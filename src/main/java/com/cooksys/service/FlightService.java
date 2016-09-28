package com.cooksys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.component.FlightGenerator;
import com.cooksys.pojo.Flight;

@Service
public class FlightService {

	@Autowired
	FlightGenerator generator;

	private List<Flight> flightList = new ArrayList<>();
	
	public List<Flight> getDailyFlightList(){
		return flightList;
	}
	
	//The fixedDelay parameter determines how often a new day is generated as expressed in milliseconds
	@Scheduled(fixedDelay=25000)
	private void refreshFlights(){
		flightList = generator.generateNewFlightList();
	}
	
	// Definitely not Recursive... or Pretty.. but kinda worked.
	// Returns a series of two connecting flights (issues with flightTime and offset still) but was unable to 
	// properly handle them when booking (and to some extent displaying) so reverted the front end
	// back to only handling direct flights.
	public List<List<Flight>> getConnectingFlights(String origin, String destination){
		List<List<Flight>> results = new ArrayList<>();
		
		List<Flight> dailyFlights = getDailyFlightList();
		
		for (Flight flight : dailyFlights) {
			List<Flight> connection = new ArrayList<>();
			if(flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)){
				connection.add(flight);
				results.add(connection);
			}else if(flight.getOrigin().equals(origin)){
				for (Flight flight2 : dailyFlights) {
					if(!flight.equals(flight2)){
						if(flight.getDestination().equals(flight2.getOrigin()) && 
								((flight.getOffset() + flight.getFlightTime() + 1) < (flight2.getOffset()))){
							if(flight2.getDestination().equals(destination)){
								connection.add(flight);
								connection.add(flight2);
								results.add(connection);
							}
						}
					}
				}
			}
		}
		return results;
		
	}
	
}
