package ru.prilepeach.Project2._Boot.service;


import ru.prilepeach.Project2._Boot.model.User;

import java.util.List;

public interface UserService {

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();

    void updateUser(User user);

    User getUserById(long id);
}
