package pl.wroc.uni.unf.webservice.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.wroc.uni.unf.domain.entity.User;
import pl.wroc.uni.unf.domain.service.NewsService;
import pl.wroc.uni.unf.domain.service.UserService;
import pl.wroc.uni.unf.domain.service.bean.UserServiceBean;
import pl.wroc.uni.unf.domain.to.UserTO;
import pl.wroc.uni.unf.utilities.mapper.DozerConverter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * author @pater
 */
public class UserControllerTest {

    private static final Long TOKEN = 1L;
    private static final String USERNAME = "unf_dev";
    private static final String PASSWORD = "password";
    private static final String MAIL = "mail@mail.com";
    private static final String ROLE = "ROLE_ADMIN";


    @Mock
    private UserService userService = Mockito.mock(UserServiceBean.class);

    private UserController controller;

    @Before
    public void setUp() {
        controller = new UserController(userService);
    }

    // Need: getUserByUsername
//    @Test
//    public void ShouldReturnUserByHisUsername()
//    {
//        assertEquals(controller.getUserByUsername(USERNAME, TOKEN), new ResponseEntity<>(createUserTO(), new HttpHeaders(), HttpStatus.OK));
//    }

    @Test
    public void ShouldReturnListWithUsers()
    {
        Mockito.when(userService.findAll()).thenReturn(createListWithUsers());

        assertEquals(controller.getAllUsers(TOKEN), new ResponseEntity<>(createListWithUsers(), new HttpHeaders(), HttpStatus.OK));
    }

// NEED: FINDALLBYROLE USERSERVICE
//    @Test
//    public void ShouldReturnListWithUsersByRole()
//    {
//        Mockito.when(userService.findAllByRole(ROLE)).thenReturn(createListWithUsers());
//
//        assertEquals(controller.getAllUsersByRole(ROLE, TOKEN), new ResponseEntity<>(createListWithUsers(), new HttpHeaders(), HttpStatus.OK));
//    }


    @Test
    public void ShouldReturnSuccessAfterAddUser() throws Exception
    {
        Mockito.when(userService.addUser(Matchers.anyString(), Matchers.anyString(), Matchers.anyString())).thenReturn(createUserTO());

        assertEquals(controller.addUser(USERNAME, PASSWORD, MAIL), new ResponseEntity<>(createUserTO(), new HttpHeaders(), HttpStatus.OK));
    }

    @Test
    public void ShouldReturnSuccessAfterUpdateUser() throws Exception
    {
        Mockito.when(userService.updateUser(Matchers.anyString(), Matchers.anyString())).thenReturn(createUserTO());

        assertEquals(controller.updateUser(USERNAME, PASSWORD, MAIL, TOKEN), new ResponseEntity<>(createUserTO(), new HttpHeaders(), HttpStatus.OK));
    }

    @Test
    public void ShouldReturnSuccessAfterDeleteUser() throws Exception
    {
        assertEquals(controller.deleteUser(USERNAME, TOKEN), new ResponseEntity(HttpStatus.OK));
    }


    private User createUser()
    {
        User user = new User();
        user.setUsername(USERNAME);
        user.setEmail(MAIL);

        return user;
    }

    private UserTO createUserTO()
    {
        DozerConverter converter = new DozerConverter();
        UserTO mappedUserTO = converter.convert(createUser(), UserTO.class);

        return mappedUserTO;
    }


    private List<UserTO> createListWithUsers()
    {
        List<UserTO> listUsers = new ArrayList<>();
        listUsers.add(createUserTO());

        return listUsers;
    }


}