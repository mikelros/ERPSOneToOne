package org.ros.hibernate.airlines;

import java.util.List;

import org.ros.hibernate.airlines.dao.AircraftDAO;
import org.ros.hibernate.airlines.dao.impl.HibernateAircraftDAO;
import org.ros.hibernate.airlines.models.Aircraft;
import org.ros.hibernate.airlines.models.Pilot;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Aircraft aircraft1 = new Aircraft("Aircraft First", 4f);
		Aircraft aircraft2 = new Aircraft("Aircraft Second", 1f);

		Pilot pilot1 = new Pilot("A", 1);
		Pilot pilot2 = new Pilot("B", 1);

		aircraft1.setPilot(pilot1);
		aircraft2.setPilot(pilot2);

		AircraftDAO aircraftDAO = new HibernateAircraftDAO();
		aircraftDAO.insert(aircraft1);
		aircraftDAO.insert(aircraft2);

		List<Aircraft> aircrafts = aircraftDAO.selectAll();

		for (Aircraft aircraft : aircrafts) {
			System.out.println("Id: " + aircraft.getId());
			System.out.println("	Autonomy: " + aircraft.getAutonomy());
			System.out.println("	Model: " + aircraft.getModel());
			System.out.println("	Pilot: " + aircraft.getPilot().toString());

		}
	}
}
