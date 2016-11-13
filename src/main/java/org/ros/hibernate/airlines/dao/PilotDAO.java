package org.ros.hibernate.airlines.dao;

import java.util.List;
import org.ros.hibernate.airlines.models.Pilot;

public interface PilotDAO {
	public Pilot selectById(Integer id);

	public List<Pilot> selectAll();

	public void insert(Pilot pilot);

	public void update(Pilot pilot);

	public void delete(Pilot pilot);
}