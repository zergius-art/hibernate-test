package ua.zerg;

import ua.zerg.models.Car;
import ua.zerg.models.User;
import ua.zerg.services.UserService;

/**
 * Main Class.
 * Realized some BL of App.
 * Full list of methods {@link ua.zerg.services.UserService}
 */
public class Main {
    public static void main(String[] args) {

        // creating new Service
        UserService userService = new UserService();

        // creating new User
        User user = new User("Zergius", 101);
        // save User to DB
        userService.saveUser(user);

        // creating new Car
        Car car1 = new Car("Ferrari", "red");
        // and bind it to User --> make a record in 'car' table
        user.addCar(car1);

        // again creating new Car
        Car car2 = new Car("Audi", "black");
        // and again bind it to User
        user.addCar(car2);

        // update DB
        userService.updateUser(user);

        // print to console list of Cars binded to User
        System.out.println(user.getCars());
    }
}