package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
public class Location {

	@Id
    @SequenceGenerator(name="location_id_seq", sequenceName="location_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="location_id_seq")
	private long id;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "city")
	private String city;

	public Location() {

	}
	
	public Location(long id, String longitude, String latitude, String city) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
