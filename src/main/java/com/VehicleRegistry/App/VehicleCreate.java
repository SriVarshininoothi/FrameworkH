package com.VehicleRegistry.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VehicleCreate {

	public void create(Vehicle v) {

		Configuration config = new Configuration(); // load the application
		config.addAnnotatedClass(com.VehicleRegistry.App.Vehicle.class);

		config.configure();

		SessionFactory factory = config.buildSessionFactory();// it is a inteface contain session
		Session session = factory.openSession(); // connect java class with database
		Transaction t = session.beginTransaction();

		session.persist(v);
		t.commit();

		session.close();
		factory.close();
	}

}
