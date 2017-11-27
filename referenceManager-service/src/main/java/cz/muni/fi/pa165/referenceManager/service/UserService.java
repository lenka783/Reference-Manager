package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.User;

import java.util.Collection;

/**
 * Interface representing UserService
 * @author Jan Bílek, Andrej Staruch
 */

public interface UserService {

    /**
     * Inserts a new user into database.
     * @param user user to be inserted
     */
    void create(User user);

    /**
     * Find an user by his id
     * @param id id of user
     * @return user with given id if found, null otherwise
     */
    User findUserById(Long id);

    /**
     * Find an user by his email
     * @param email email of user
     * @return user with given email if found, null otherwise
     */
    User findUserByEmail(String email);

    /**
     * Register user into the system. Plain password will be hashed
     * and then stored in database.
     * @param userId id of user
     * @param plainPassword obtained password to be hashed
     */
    void registerUser(Long userId, String plainPassword);

    /**
     * Get all users stored in database
     * @return all users stored in database
     */
    Collection<User> getAllUsers();

    /**
     * Authenticate user into the system
     * @param userId user's id
     * @param password user's password
     * @return true if entered password is correct, false otherwise
     */
    boolean authenticate(Long userId, String password);

    /**
     * Add reference into user's collection of references
     * @param userId id of user
     * @param referenceId id of reference to be added
     */
    void addReference(Long userId, Long referenceId);

    /**
     * Remove reference from user's collection of references
     * @param userId id of user
     * @param referenceId id of reference to be removed
     */
    void removeReference(Long userId,  Long referenceId);

    /**
     * Add tag into user's own tags used for categorizing of references
     * @param userId id of user
     * @param tagId id of tag to add
     */
    void addTag(Long userId, Long tagId);

    /**
     * Remove to from user's own tags for categorizing of references
     * @param userId id of user
     * @param tagId id of tag to be removed
     */
    void removeTag(Long userId, Long tagId);

    /**
     * Add user into tag's collection of users for sharing references between users
     * @param userId id of user to be add into collection
     * @param tagId id of tag into the user will be added
     */
    void shareTag(Long userId, Long tagId);

    /**
     * Remove user from tag's collection of users for sharing references between users
     * @param userId id of user to be removed from collection
     * @param tagId id of tag from where user will be removed
     */
    void unshareTag(Long userId, Long tagId);

}
