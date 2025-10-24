package com.VehicleRegistry.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VehicleDelete {

	public void delete(int id) {

		Configuration config = new Configuration(); // load the application
		config.addAnnotatedClass(com.VehicleRegistry.App.Vehicle.class);

		config.configure();

		SessionFactory factory = config.buildSessionFactory();// it is a inteface contain session
		Session session = factory.openSession(); // connect java class with database
		Transaction t = session.beginTransaction();

		Vehicle v = session.find(Vehicle.class, id);
		if (v != null) {
			session.remove(v);
			System.out.println("✅ Vehicle deleted successfully!");
		}else {
			System.out.println("⚠️ Vehicle with ID \" + id + \" not found.");
		}

		t.commit();

		session.close();
		factory.close();
	}

}
