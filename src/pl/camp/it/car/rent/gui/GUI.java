package pl.camp.it.car.rent.gui;

import pl.camp.it.car.rent.Authenticator;
import pl.camp.it.car.rent.database.VehicleDB;
import pl.camp.it.car.rent.model.*;
import pl.camp.it.car.rent.model.builders.MotorcycleBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GUI {
    public static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    public static void showMenu() {
        System.out.println("1. List vehicles");
        System.out.println("2. Rent vehicle");
        if(Authenticator.loggedUser.getRole() == User.Role.ADMIN) {
            System.out.println("3. Add vehicle");
        }

        System.out.println("4. Exit");
    }

    public static void listVehicles(List<Vehicle> vehicles) {
        for(Vehicle currentVehicle : vehicles) {
            System.out.println(currentVehicle);
        }
    }

    public static User readLoginAndPassword() throws IOException {
        System.out.println("Login:");
        String login = reader.readLine();
        System.out.println("Password:");
        return new User(login, reader.readLine());
    }

    public static void addVehicle(VehicleDB vehicleDB) throws IOException {
        System.out.println("1. Car");
        System.out.println("2. Bus");
        System.out.println("3. Motorcycle");
        String type = reader.readLine();
        switch (type) {
            case "1":
                Car car = new Car();
                System.out.println("Brand:");
                car.setBrand(reader.readLine());
                System.out.println("Model:");
                car.setModel(reader.readLine());
                System.out.println("Year:");
                car.setYear(Integer.parseInt(reader.readLine()));
                car.setRent(false);
                System.out.println("Plate:");
                car.setPlate(reader.readLine());
                System.out.println("Price:");
                car.setPrice(Double.parseDouble(reader.readLine()));
                vehicleDB.addVehicle(car);
                System.out.println("Car added !!");
                break;
            case "2":
                Bus bus = new Bus();
                System.out.println("Brand:");
                bus.setBrand(reader.readLine());
                System.out.println("Model:");
                bus.setModel(reader.readLine());
                System.out.println("Year:");
                bus.setYear(Integer.parseInt(reader.readLine()));
                bus.setRent(false);
                System.out.println("Plate:");
                bus.setPlate(reader.readLine());
                System.out.println("Price:");
                bus.setPrice(Double.parseDouble(reader.readLine()));
                System.out.println("Seats:");
                bus.setSeats(Integer.parseInt(reader.readLine()));
                vehicleDB.addVehicle(bus);
                System.out.println("Bus added !!");
                break;
            case "3":
                MotorcycleBuilder mb = new MotorcycleBuilder();
                System.out.println("Brand:");
                mb.brand(reader.readLine());
                System.out.println("Model:");
                mb.model(reader.readLine());
                System.out.println("Year:");
                mb.year(Integer.parseInt(reader.readLine()));
                System.out.println("Plate:");
                mb.plate(reader.readLine());
                System.out.println("Price:");
                mb.price(Double.parseDouble(reader.readLine()));
                System.out.println("Has cart (y/n):");
                mb.cart(reader.readLine().equals("y"));
                vehicleDB.addVehicle(mb.build());
                System.out.println("Motorcycle added !!");
                break;
            default:
                System.out.println("Wrong choose !!");
                break;
        }
    }
}
