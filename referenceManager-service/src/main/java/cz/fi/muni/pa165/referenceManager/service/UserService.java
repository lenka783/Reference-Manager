package cz.fi.muni.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.Reference;
import cz.muni.fi.pa165.referenceManager.entity.Tag;
import cz.muni.fi.pa165.referenceManager.entity.User;
import org.hibernate.service.spi.InjectService;

import java.util.Collection;

public interface UserService {

    User findUserById(Long id);

    User findUserByEmail(String email);

    void registerUser(User user, String plainPassword);

    Collection<User> getAllUsers();

    boolean authenticate(User user, String password);

    void addReference(User user, Reference reference);

    void removeReference(User user, Reference reference);

    void addTag(User user, Tag tag);

    void removeTag(User user, Tag tag);
}
