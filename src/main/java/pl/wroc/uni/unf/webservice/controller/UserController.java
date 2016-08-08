package pl.wroc.uni.unf.webservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wroc.uni.unf.domain.entity.User;

/**
 * @author pater.
 */

@RestController
@RequestMapping("/api/v1/user")

public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public User user(
            @RequestParam(value="token", defaultValue="-1") Long userToken) {

        User exampleUser = new User();
        exampleUser.setUsername("test");

        return exampleUser;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addUser(
            @RequestParam(value="title", defaultValue="default") String newsTitle,
            @RequestParam(value="description", defaultValue="default") String newsDescription,
            @RequestParam(value="token", defaultValue="-1") Long userToken) {

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(
            @RequestParam(value="id", defaultValue="0") Long newsId,
            @RequestParam(value="token", defaultValue="-1") Long userToken) {

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


}
