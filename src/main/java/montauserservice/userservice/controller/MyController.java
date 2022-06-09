package montauserservice.userservice.controller;

import montauserservice.userservice.service.MontaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller that provide client with the list of users and the number of exams they are attended
 * @author MasoudIder
 */
@RestController
@RequestMapping("/users")
public class MyController {

    @Autowired
    private MontaUserService service;


    @GetMapping
    public ResponseEntity getAllUsers() {

        return new ResponseEntity(service.findUsersAndTheNumberOfExams(), HttpStatus.OK);
    }
}
