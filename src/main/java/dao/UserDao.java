package dao;

import entity.User;

import java.util.List;

/**
 * @author David Šarman
 */
public interface UserDao {
    void create(User u);

    void update(User u);

    void remove(User u);

    User findById(Long id);

    User findUserByEmail(String email);

    List<User> findAll();
}
