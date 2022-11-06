package pl.camp.it.car.rent.model;

public class Car extends Vehicle {

    public Car(String brand, String model,
               int year, boolean rent,
               String plate, double price) {
        super(brand, model, year, rent, plate, price);
    }

    public Car(String[] params) {
        super(params[1],
                params[2],
                Integer.parseInt(params[3]),
                Boolean.parseBoolean(params[4]),
                params[5],
                Double.parseDouble(params[6]));
    }

    public Car() {
    }
}
