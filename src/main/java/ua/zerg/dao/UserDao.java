package ua.zerg.dao;

import ua.zerg.models.User;
import ua.zerg.models.Car;
import java.util.List;

/**
 * DAO Interface
 */
public interface UserDao {

    public User findById(int id);
    public void save(User user);
    public void update(User user);
    public void delete(User user);
    public Car findCarById(int id);
    public List<User> findAll();
}
