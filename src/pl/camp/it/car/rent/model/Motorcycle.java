package pl.camp.it.car.rent.model;

public class Motorcycle extends Vehicle {

    private boolean cart;

    public Motorcycle(String brand, String model,
                      int year, boolean rent,
                      String plate, double price, boolean cart) {
        super(brand, model, year, rent, plate, price);
        this.cart = cart;
    }

    public Motorcycle(String[] params) {
        super(params[1],
                params[2],
                Integer.parseInt(params[3]),
                Boolean.parseBoolean(params[4]),
                params[5],
                Double.parseDouble(params[6]));
        this.cart = Boolean.parseBoolean(params[7]);
    }

    public Motorcycle() {
    }

    public boolean isCart() {
        return cart;
    }

    public void setCart(boolean cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return super.toString() + " Cart: " + (this.cart ? "Tak" : "Nie");
    }

    @Override
    public String convertToData() {
        return super.convertToData() + ";" + this.cart;
    }
}
