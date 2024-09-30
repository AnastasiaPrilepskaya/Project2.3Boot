package ru.prilepeach.Project2._Boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prilepeach.Project2._Boot.dao.UserDao;
import ru.prilepeach.Project2._Boot.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUserById(user.getId(), user.getName(), user.getLastName(), user.getAge());
    }

    @Override
    public User getUserById(long id) {
        return  userDao.getUserById(id);
    }
}
