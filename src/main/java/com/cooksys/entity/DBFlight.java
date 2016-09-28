package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DBFlight")
public class DBFlight {

	@Id
    @SequenceGenerator(name="flight_id_seq", sequenceName="flight_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="flight_id_seq")
	private Long id;
	
	@Column(nullable=false)
	private String origin;
	
	@Column(nullable=false)
	private String destination;
	
	@Column(nullable=false)
	private long flightTime;
	
	@Column(name = "offsetTime", nullable=false)
	private long offset;
	
	public DBFlight () {
		
	}
	
	public DBFlight (String origin, String destination, long flightTime, long offset) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.flightTime = flightTime;
		this.offset = offset;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public long getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(long flightTime) {
		this.flightTime = flightTime;
	}

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}
}
