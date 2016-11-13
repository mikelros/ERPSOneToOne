package org.ros.hibernate.airlines.models;

import javax.persistence.*;
@Entity
public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer license;
	
	@OneToOne(mappedBy = "pilot", cascade = CascadeType.ALL)
	private Aircraft aircraft;
	
	public Pilot() {}

	public Pilot(String name, Integer license) {
		super();
		this.name = name;
		this.license = license;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLicense() {
		return license;
	}

	public void setLicense(Integer license) {
		this.license = license;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
		aircraft.setPilot(this);
	}

	@Override
	public String toString() {
		return "Name=" + name + ", license=" + license;
	}
	
	
}
