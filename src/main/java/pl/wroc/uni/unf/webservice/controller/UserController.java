package pl.wroc.uni.unf.webservice.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wroc.uni.unf.domain.entity.User;

/**
 * @author pater
 */

@RestController
@RequestMapping("/api/v1/user")

public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<User> user(
			@RequestParam(value = "token", defaultValue = "-1") Long userToken) {

		User exampleUser = new User();
		exampleUser.setUsername("test");

		return new ResponseEntity<>(exampleUser, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity addUser(
			@RequestParam(value = "login", defaultValue = "default") String login,
			@RequestParam(value = "password", defaultValue = "default") String password,
			@RequestParam(value = "email", defaultValue = "default") String email) {

		User exampleUser = new User();

		return new ResponseEntity<>(exampleUser, new HttpHeaders(), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity deleteUser(
			@RequestParam(value = "token", defaultValue = "-1") Long userToken) {

		return new ResponseEntity(HttpStatus.OK);
	}


}
