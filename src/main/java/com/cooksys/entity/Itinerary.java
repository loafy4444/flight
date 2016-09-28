package com.cooksys.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Itinerary {

	@Id
    @SequenceGenerator(name="itinerary_id_seq", sequenceName="itinerary_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="itinerary_id_seq")
	private Long id;
	
	@ManyToOne(optional=false)
	@JoinColumn
	private Customer customer;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="flight_path")
	private List<DBFlight> flight;

	public Itinerary () {
		
	}
	
	public Itinerary (Customer customer, List<DBFlight> flight) {
		super();
		this.customer = customer;
		this.flight = flight;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<DBFlight> getFlights() {
		return flight;
	}

	public void setFlights(List<DBFlight> flight) {
		this.flight = flight;
	}
	
	
}
