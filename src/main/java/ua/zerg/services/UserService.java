package ua.zerg.services;

import ua.zerg.dao.UserDao;
import ua.zerg.dao.UserDaoImpl;
import ua.zerg.models.Car;
import ua.zerg.models.User;

import java.util.List;

public class UserService {

    private UserDao userDao = new UserDaoImpl();

    public UserService() {
    }

    public User findUser(int id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public Car findCarById(int id) {
        return userDao.findCarById(id);
    }
}
