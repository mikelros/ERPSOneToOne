package org.ros.hibernate.airlines.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ros.hibernate.airlines.HibernateSession;
import org.ros.hibernate.airlines.dao.PilotDAO;
import org.ros.hibernate.airlines.models.Pilot;

public class HibernatePilotDAO implements PilotDAO {
	public Pilot selectById(Integer id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Pilot pilot = (Pilot) session.get(Pilot.class, id);
		session.close();
		return pilot;
	}

	public List<Pilot> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Pilot> pilots = session.createCriteria(Pilot.class).list();
		session.close();
		return pilots;
	}

	public void insert(Pilot pilot) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(pilot);
		pilot.setId(id);
		session.getTransaction().commit();
		session.close();
		
	}

	public void update(Pilot pilot) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(pilot);
		session.getTransaction().commit();
		session.close();
		
	}

	public void delete(Pilot pilot) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(pilot);
		session.getTransaction().commit();
		session.close();
		
	}
}
