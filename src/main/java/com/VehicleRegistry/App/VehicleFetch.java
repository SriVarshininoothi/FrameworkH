package com.VehicleRegistry.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class VehicleFetch {

	public Vehicle fetch(int id) {

		Configuration confg = new Configuration().addAnnotatedClass(com.VehicleRegistry.App.Vehicle.class).configure();

		SessionFactory factory = confg.buildSessionFactory();

		Session session = factory.openSession();

		Vehicle v = session.find(Vehicle.class, id);// Eager feteching

		// session.byId(Vehicle.class).getReference(2); // lazy feteching

		factory.close();
		session.close();

		return v;

	}
}
