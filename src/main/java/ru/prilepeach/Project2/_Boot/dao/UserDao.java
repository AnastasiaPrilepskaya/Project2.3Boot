package ru.prilepeach.Project2._Boot.dao;


import ru.prilepeach.Project2._Boot.model.User;

import java.util.List;


public interface UserDao {

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();

    void updateUserById(long id, String name, String lastName, byte age);

    User getUserById(long id);
}
