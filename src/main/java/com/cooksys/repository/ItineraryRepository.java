package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Itinerary;
import com.cooksys.model.ItineraryModel;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

	ItineraryModel findById(Long id);
	
//	List<Itinerary> findByCustomer(Long id);
}
