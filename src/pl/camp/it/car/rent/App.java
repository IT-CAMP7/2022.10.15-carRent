package pl.camp.it.car.rent;

import pl.camp.it.car.rent.core.Engine;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            Engine.start();
        } catch (IOException e) {
            System.out.println("Nie dziala wczytywanie z klawiatury !!");
        }
    }
}
