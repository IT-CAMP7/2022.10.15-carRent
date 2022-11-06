package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.Bus;
import pl.camp.it.car.rent.model.Car;
import pl.camp.it.car.rent.model.Motorcycle;
import pl.camp.it.car.rent.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDB {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public VehicleDB() {
        this.vehicles.add(new Car("Audi", "A3",
                2005, "KR11", 300.00));
        this.vehicles.add(new Car("BMW", "3",
                2006, "KR22", 250.00));
        this.vehicles.add(new Car("Toyota", "Corolla",
                2010, "KR33", 200.00));
        this.vehicles.add(new Car("Mercedes", "C",
                2020, "KR44", 500.00));
        this.vehicles.add(new Car("Kia", "Ceed",
                2011, "KR55", 300.00));

        this.vehicles.add(new Bus("Solaris", "2000",
                2010, "KR66", 500.00, 52));
        this.vehicles.add(new Bus("Solaris", "3000",
                2011, "KR77", 550.00, 62));

        this.vehicles.add(new Motorcycle("Suzuki", "5000",
                2016, "KR88", 400.00, true));
    }

    public boolean rentVehicle(String plate) {
        for(Vehicle currentVehicle : this.vehicles) {
            if(currentVehicle.getPlate().equals(plate) && !currentVehicle.isRent()) {
                currentVehicle.setRent(true);
                return true;
            }
        }

        return false;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
