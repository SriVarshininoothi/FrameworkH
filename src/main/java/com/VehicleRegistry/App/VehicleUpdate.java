package com.VehicleRegistry.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VehicleUpdate {

	public void update(int id, String newOwner, String newModel, String newRegister, String newType) {

		Configuration config = new Configuration();
		config.addAnnotatedClass(com.VehicleRegistry.App.Vehicle.class);
		config.configure();

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		// Get existing record
		Vehicle existing = session.find(Vehicle.class, id);

		if (existing != null) {
			// Set new values
			existing.setOwnerName(newOwner);
			existing.setModel(newModel);
			existing.setRegistrationNumber(newRegister);
			existing.setType(newType);

			// Use merge() to update
			session.merge(existing);

			System.out.println("✅ Vehicle updated successfully!");
		} else {
			System.out.println("⚠️ Vehicle with ID " + id + " not found!");
		}

		t.commit();
		session.close();
		factory.close();
	}
}
