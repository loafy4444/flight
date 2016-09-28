package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.DBFlight;
import com.cooksys.repository.DBFlightRepository;

@Service
public class DBFlightService {

	private final DBFlightRepository repo;
	
	@Autowired
	public DBFlightService(DBFlightRepository repo){
		this.repo = repo;
	}
	
	public List<DBFlight> index(){
		return this.repo.findAll();
	} 
	
	public List<DBFlight> indexByOrigin(String origin){
		return this.repo.findByOrigin(origin);
	}
	
	public List<DBFlight> indexByDestination(String destination){
		return this.repo.findByDestination(destination);
	}
	
	public DBFlight read(Long id){
		return this.repo.findById(id);
	}
	
	public DBFlight create(DBFlight flight){
		DBFlight result = flight;
		this.repo.saveAndFlush(result);
		return result;
	}
}
