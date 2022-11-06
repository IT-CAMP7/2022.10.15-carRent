package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDB {
    private final Map<String, User> users = new HashMap<>();

    public UserDB() {
        this.users.put("mateusz", new User("mateusz",
                "fff2f9619b803349d3d2a269306c0002", User.Role.USER));
        this.users.put("admin", new User("admin",
                "34fabc41d484eb1563a1c188e0b30718", User.Role.ADMIN));
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public User findUserByLogin(String login) {
        return this.users.get(login);
    }
}
