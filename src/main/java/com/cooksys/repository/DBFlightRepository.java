package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.DBFlight;

public interface DBFlightRepository extends JpaRepository<DBFlight, Long> {

//	List<DBFlight> index();
	
	List<DBFlight> findByOrigin(String origin);
	
	List<DBFlight> findByDestination(String destination);
	
	DBFlight findById(Long id);
}
