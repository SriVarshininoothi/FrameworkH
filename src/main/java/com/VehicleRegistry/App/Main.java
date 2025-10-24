package com.VehicleRegistry.App;

public class Main {
	public static void main(String[] args) {
		Vehicle v = new Vehicle();

		v.setId(5);
		v.setOwnerName("Dora");
		v.setRegistrationNumber("APEGTRF");
		v.setModel("Audi");
		v.setType("Car");

		VehicleCreate c = new VehicleCreate();
		c.create(v);

		VehicleFetch f = new VehicleFetch();
		Vehicle found = f.fetch(1);
		System.out.print(found);

		VehicleUpdate u = new VehicleUpdate();
		u.update(2, "Usha", "Honda", "AP02345", "Bike");

		VehicleDelete d = new VehicleDelete();
		d.delete(5);

	}
}
