package cz.fi.muni.pa165.referenceManager.facade;

import cz.fi.muni.pa165.referenceManager.dto.UserDTO;
import cz.fi.muni.pa165.referenceManager.dto.UserLoginDTO;

import java.util.Collection;

public interface UserFacade {

    UserDTO findUserById(Long id);

    UserDTO findUserByEmail(String email);

    void registerUser(UserDTO user, String plainPassword);

    Collection<UserDTO> getAllUsers();

    boolean authenticate(UserLoginDTO user);
}
