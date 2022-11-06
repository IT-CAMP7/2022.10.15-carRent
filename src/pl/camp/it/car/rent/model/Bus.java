package pl.camp.it.car.rent.model;

public class Bus extends Vehicle {
    private int seats;

    public Bus(String brand, String model,
               int year, boolean rent,
               String plate, double price, int seats) {
        super(brand, model, year, rent, plate, price);
        this.seats = seats;
    }

    public Bus(String[] params) {
        super(params[1],
                params[2],
                Integer.parseInt(params[3]),
                Boolean.parseBoolean(params[4]),
                params[5],
                Double.parseDouble(params[6]));
        this.seats = Integer.parseInt(params[7]);
    }

    public Bus() {
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return super.toString() + " Miejsca: " + this.seats;
    }

    @Override
    public String convertToData() {
        return super.convertToData() + ";" + this.seats;
    }
}
