package pl.camp.it.car.rent.gui;

import pl.camp.it.car.rent.Authenticator;
import pl.camp.it.car.rent.database.VehicleDB;
import pl.camp.it.car.rent.model.*;
import pl.camp.it.car.rent.model.builders.MotorcycleBuilder;

import java.util.List;
import java.util.Scanner;

public class GUI {
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

    public static User readLoginAndPassword() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Password:");
        return new User(login, scanner.nextLine());
    }

    public static void addVehicle(VehicleDB vehicleDB) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("1. Car");
        System.out.println("2. Bus");
        System.out.println("3. Motorcycle");
        String type = scanner.nextLine();
        switch (type) {
            case "1":
                Car car = new Car();
                System.out.println("Brand:");
                car.setBrand(scanner.nextLine());
                System.out.println("Model:");
                car.setModel(scanner.nextLine());
                System.out.println("Year:");
                car.setYear(Integer.parseInt(scanner.nextLine()));
                car.setRent(false);
                System.out.println("Plate:");
                car.setPlate(scanner.nextLine());
                System.out.println("Price:");
                car.setPrice(Double.parseDouble(scanner.nextLine()));
                vehicleDB.addVehicle(car);
                System.out.println("Car added !!");
                break;
            case "2":
                Bus bus = new Bus();
                System.out.println("Brand:");
                bus.setBrand(scanner.nextLine());
                System.out.println("Model:");
                bus.setModel(scanner.nextLine());
                System.out.println("Year:");
                bus.setYear(Integer.parseInt(scanner.nextLine()));
                bus.setRent(false);
                System.out.println("Plate:");
                bus.setPlate(scanner.nextLine());
                System.out.println("Price:");
                bus.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Seats:");
                bus.setSeats(Integer.parseInt(scanner.nextLine()));
                vehicleDB.addVehicle(bus);
                System.out.println("Bus added !!");
                break;
            case "3":
                MotorcycleBuilder mb = new MotorcycleBuilder();
                System.out.println("Brand:");
                mb.brand(scanner.nextLine());
                System.out.println("Model:");
                mb.model(scanner.nextLine());
                System.out.println("Year:");
                mb.year(Integer.parseInt(scanner.nextLine()));
                System.out.println("Plate:");
                mb.plate(scanner.nextLine());
                System.out.println("Price:");
                mb.price(Double.parseDouble(scanner.nextLine()));
                System.out.println("Has cart (y/n):");
                mb.cart(scanner.nextLine().equals("y"));
                vehicleDB.addVehicle(mb.build());
                System.out.println("Motorcycle added !!");
                break;
            default:
                System.out.println("Wrong choose !!");
                break;
        }
    }
}
