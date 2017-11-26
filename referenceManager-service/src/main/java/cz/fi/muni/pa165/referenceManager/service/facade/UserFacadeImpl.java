package cz.fi.muni.pa165.referenceManager.service.facade;

import cz.fi.muni.pa165.referenceManager.dto.ReferenceDTO;
import cz.fi.muni.pa165.referenceManager.dto.TagDTO;
import cz.fi.muni.pa165.referenceManager.dto.UserDTO;
import cz.fi.muni.pa165.referenceManager.dto.UserLoginDTO;
import cz.fi.muni.pa165.referenceManager.facade.UserFacade;
import cz.fi.muni.pa165.referenceManager.service.MappingService;
import cz.fi.muni.pa165.referenceManager.service.UserService;
import cz.muni.fi.pa165.referenceManager.entity.Reference;
import cz.muni.fi.pa165.referenceManager.entity.Tag;
import cz.muni.fi.pa165.referenceManager.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@Service
public class UserFacadeImpl implements UserFacade {

    @Inject
    UserService userService;

    @Inject
    MappingService mappingService;

    @Override
    public UserDTO findUserById(Long id) {
        User user = userService.findUserById(id);
        return mappingService.mapTo(user, UserDTO.class);
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        User user = userService.findUserByEmail(email);
        return mappingService.mapTo(user, UserDTO.class);
    }

    @Override
    public void registerUser(UserDTO userDTO, String plainPassword) {
        User user = mappingService.mapTo(userDTO, User.class);
        userService.registerUser(user, plainPassword);
        userDTO.setId(user.getId());
    }

    @Override
    public boolean authenticate(UserLoginDTO userDTO) {
        User user = userService.findUserByEmail(userDTO.getEmail());
        return userService.authenticate(user, userDTO.getPassword());
    }

    @Override
    public void addReference(Long userId, ReferenceDTO referenceDTO) {
        User user = userService.findUserById(userId);
        Reference reference = mappingService.mapTo(referenceDTO, Reference.class);
        userService.addReference(user, reference);
    }

    @Override
    public void removeReference(Long userId, ReferenceDTO referenceDTO) {
        User user = userService.findUserById(userId);
        Reference reference = mappingService.mapTo(referenceDTO, Reference.class);
        userService.removeReference(user, reference);
    }

    @Override
    public void addTag(Long userId, TagDTO tagDTO) {
        User user = userService.findUserById(userId);
        Tag tag = mappingService.mapTo(tagDTO, Tag.class);
        userService.addTag(user, tag);
    }

    @Override
    public void removeTag(Long userId, TagDTO tagDTO) {
        User user = userService.findUserById(userId);
        Tag tag = mappingService.mapTo(tagDTO, Tag.class);
        userService.removeTag(user, tag);
    }

    @Override
    public Collection<UserDTO> getAllUsers() {
        return mappingService.mapTo(userService.getAllUsers(), UserDTO.class);
    }
}
