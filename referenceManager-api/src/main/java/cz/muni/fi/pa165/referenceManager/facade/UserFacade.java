package cz.muni.fi.pa165.referenceManager.facade;

import cz.muni.fi.pa165.referenceManager.dto.ReferenceDTO;
import cz.muni.fi.pa165.referenceManager.dto.TagDTO;
import cz.muni.fi.pa165.referenceManager.dto.UserDTO;
import cz.muni.fi.pa165.referenceManager.dto.UserLoginDTO;

import java.util.Collection;

/**
 * @author Jan Bílek
 */
public interface UserFacade {

    UserDTO findUserById(Long id);

    UserDTO findUserByEmail(String email);

    void registerUser(UserDTO user, String plainPassword);

    Collection<UserDTO> getAllUsers();

    boolean authenticate(UserLoginDTO user);

    void addReference(Long userId, ReferenceDTO reference);

    void removeReference(Long userId, ReferenceDTO reference);

    void addTag(Long userId, TagDTO tag);

    void removeTag(Long userId, TagDTO tag);
}
