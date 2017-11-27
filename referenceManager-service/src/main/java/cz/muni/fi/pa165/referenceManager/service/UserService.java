package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.Reference;
import cz.muni.fi.pa165.referenceManager.entity.Tag;
import cz.muni.fi.pa165.referenceManager.entity.User;
import org.hibernate.service.spi.InjectService;

import java.util.Collection;

/**
 * @author Jan Bílek
 */

public interface UserService {

    void create(User user);

    User findUserById(Long id);

    User findUserByEmail(String email);

    void registerUser(User user, String plainPassword);

    Collection<User> getAllUsers();

    boolean authenticate(User user, String password);

    void addReference(User user, Reference reference);

    void removeReference(User user, Reference reference);

    void addTag(Long userId, Long tagId);

    void removeTag(Long userId, Long tagId);

    void shareTag(Long userId, Long tagId);

    void unshareTag(Long userId, Long tagId);

}
