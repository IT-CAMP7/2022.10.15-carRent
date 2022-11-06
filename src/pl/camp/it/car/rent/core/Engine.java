package pl.camp.it.car.rent.core;

import pl.camp.it.car.rent.Authenticator;
import pl.camp.it.car.rent.database.UserDB;
import pl.camp.it.car.rent.database.VehicleDB;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;

import java.io.IOException;

public class Engine {

    public static void start() throws IOException {
        final VehicleDB vehicleDB = new VehicleDB();
        final UserDB userDB = new UserDB();
        boolean isWorking = Authenticator.authenticate(userDB);

        while(isWorking) {
            GUI.showMenu();
            switch(GUI.reader.readLine()) {
                case "1":
                    GUI.listVehicles(vehicleDB.getVehicles());
                    break;
                case "2":
                    System.out.println("Plate:");
                    if(vehicleDB.rentVehicle(GUI.reader.readLine())) {
                        System.out.println("You have rent this vehicle !!!");
                    } else {
                        System.out.println("Rent error !!");
                    }
                    break;
                case "4":
                    GUI.reader.close();
                    vehicleDB.persistToFile();
                    userDB.persistToFile();
                    isWorking = false;
                    break;
                case "3":
                    if(Authenticator.loggedUser.getRole() == User.Role.ADMIN) {
                        GUI.addVehicle(vehicleDB);
                        break;
                    }
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
}
