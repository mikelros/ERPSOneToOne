package org.ros.hibernate.airlines.dao;

import java.util.List;

import org.ros.hibernate.airlines.models.Aircraft;

public interface AircraftDAO {
	public Aircraft selectById(Integer id);

	public List<Aircraft> selectAll();

	public void insert(Aircraft aircraft);

	public void update(Aircraft aircraft);

	public void delete(Aircraft aircraft);
}
