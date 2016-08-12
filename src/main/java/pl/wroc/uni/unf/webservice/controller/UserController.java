package pl.wroc.uni.unf.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wroc.uni.unf.domain.entity.User;
import pl.wroc.uni.unf.domain.service.UserService;
import pl.wroc.uni.unf.domain.to.UserTO;

import java.util.List;

/**
 * @author pater
 */

@RestController
@RequestMapping("/api/v1/user")

public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	public UserController() {}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<UserTO> getUserByUsername(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "token", defaultValue = "-1") Long userToken) {

		return new ResponseEntity<>(userService.find(username), new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(
			@RequestParam(value = "token", defaultValue = "-1") Long userToken) {

		return new ResponseEntity(userService.findAll(), new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsersByRole(
			@RequestParam(value = "role") String role,
			@RequestParam(value = "token", defaultValue = "-1") Long userToken) {

		return null;
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity addUser(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password", defaultValue = "default") String password,
			@RequestParam(value = "email", defaultValue = "default") String email) {

		return new ResponseEntity(userService.addUser(username, password, email), new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<UserTO> updateUser(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password", defaultValue = "default") String password,
			@RequestParam(value = "email", defaultValue = "default") String email,
			@RequestParam(value = "token", defaultValue = "-1") Long userToken){

		UserTO user = userService.updateUser(username, email);
		userService.changePassword(username, password);

		return new ResponseEntity(user, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity deleteUser(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "token", defaultValue = "-1") Long userToken) {

		userService.deleteUser(username);

		return new ResponseEntity(HttpStatus.OK);
	}


}
