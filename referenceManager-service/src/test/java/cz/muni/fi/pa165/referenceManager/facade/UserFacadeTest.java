package cz.muni.fi.pa165.referenceManager.facade;

import cz.muni.fi.pa165.referenceManager.dto.UserDTO;
import cz.muni.fi.pa165.referenceManager.entity.User;
import cz.muni.fi.pa165.referenceManager.service.UserService;
import cz.muni.fi.pa165.referenceManager.config.ServiceConfiguration;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ServiceConfiguration.class)
public class UserFacadeTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserFacade userFacade = new UserFacadeImpl();

    private UserDTO userDTO;
    private User user;

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
    }

}
