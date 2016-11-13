package org.ros.hibernate.airlines.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ros.hibernate.airlines.HibernateSession;
import org.ros.hibernate.airlines.dao.AircraftDAO;
import org.ros.hibernate.airlines.models.Aircraft;

public class HibernateAircraftDAO implements AircraftDAO {
	public Aircraft selectById(Integer id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Aircraft aircraft = (Aircraft) session.get(Aircraft.class, id);
		session.close();
		return aircraft;
	}

	public List<Aircraft> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Aircraft> aircrafts = session.createCriteria(Aircraft.class).list();
		session.close();
		return aircrafts;
	}

	public void insert(Aircraft aircraft) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(aircraft);
		aircraft.setId(id);
		session.getTransaction().commit();
		session.close();
		
	}

	public void update(Aircraft aircraft) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(aircraft);
		session.getTransaction().commit();
		session.close();
		
	}

	public void delete(Aircraft aircraft) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(aircraft);
		session.getTransaction().commit();
		session.close();
		
	}
}
