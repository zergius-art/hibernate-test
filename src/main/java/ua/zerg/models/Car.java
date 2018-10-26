package ua.zerg.models;

import javax.persistence.*;

/**
 * Entity "Car" connect to Table "car" in the DB
 *   Table "car" has four columns
 *      id, model, color, user_id (foreign key for 'user')
 */
@Entity
@Table(name = "car", schema = "public")
public class Car {

    // Connecting DB Table "car" with class "Car"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //Constructors
    public Car() {
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
