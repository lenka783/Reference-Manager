package cz.muni.fi.pa165.referenceManager.facade;

import cz.muni.fi.pa165.referenceManager.dto.ReferenceDTO;
import cz.muni.fi.pa165.referenceManager.dto.TagDTO;
import cz.muni.fi.pa165.referenceManager.dto.UserDTO;
import cz.muni.fi.pa165.referenceManager.dto.UserLoginDTO;

import java.util.Collection;

/**
 * @author Jan Bílek, Andrej Staruch
 */
public interface UserFacade {

    void registerUser(UserDTO user, String plainPassword);

    UserDTO findUserById(Long id);

    UserDTO findUserByEmail(String email);

    Collection<UserDTO> getAllUsers();

    boolean authenticate(UserLoginDTO userLoginDTO);

    void addReference(Long userId, Long referenceId);

    void removeReference(Long userId, Long referenceId);

    void addTag(Long userId, Long tagId);

    void removeTag(Long userId, Long tagId);

    void shareTag(Long userId, Long tagId);

    void unshareTag(Long userId, Long tagId);
}
