package ru.prilepeach.Project2._Boot.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.prilepeach.Project2._Boot.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUsersTable() {
        entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS users (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                " name VARCHAR(30), last_name VARCHAR(30), age TINYINT)").executeUpdate();
    }

    @Override
    public void dropUsersTable() {
        entityManager.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
    }

    @Transactional
    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void removeUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void cleanUsersTable() {
        entityManager.createNativeQuery("TRUNCATE TABLE users").executeUpdate();
    }

    @Transactional
    @Override
    public void updateUserById(long id, String name, String lastName, byte age) {
        User user = entityManager.find(User.class, id);
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        entityManager.persist(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}

