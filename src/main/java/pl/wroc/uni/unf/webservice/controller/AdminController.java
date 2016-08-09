package pl.wroc.uni.unf.webservice.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Notechus.
 */
@RestController
@Secured("ROLE_ADMIN")
@RequestMapping("/api/v1/admin")
public class AdminController {

}
