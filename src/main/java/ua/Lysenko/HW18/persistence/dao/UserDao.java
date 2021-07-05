package ua.Lysenko.HW18.persistence.dao;


import ua.Lysenko.HW18.persistence.entity.User;

import java.util.List;

public interface UserDao {

    void create(User user);

    void update(User user);

    void delete(String id);

    User findById(String id);

    boolean existByEmail(String email);

    List<User> findAll();
}

