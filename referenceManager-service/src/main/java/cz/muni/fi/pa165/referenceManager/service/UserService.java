package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.User;

import java.util.Collection;

/**
 * @author Jan Bílek, Andrej Staruch
 */

public interface UserService {

    void create(User user);

    User findUserById(Long id);

    User findUserByEmail(String email);

    void registerUser(Long userId, String plainPassword);

    Collection<User> getAllUsers();

    boolean authenticate(Long userId, String password);

    void addReference(Long userId, Long referenceId);

    void removeReference(Long userId,  Long referenceId);

    void addTag(Long userId, Long tagId);

    void removeTag(Long userId, Long tagId);

    void shareTag(Long userId, Long tagId);

    void unshareTag(Long userId, Long tagId);

}
