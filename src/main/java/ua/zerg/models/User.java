package ua.zerg.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity "User" connect to Table "user" in the DB
 *   Table "user" has three columns
 *      id, name, age
 */
@Entity
@Table(name = "user", schema = "public")
public class User {

    // Connecting DB Table "user" with class "User"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

    // Constructors
    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        cars = new ArrayList<Car>();
    }

    public void addCar(Car car) {
        car.setUser(this);
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
