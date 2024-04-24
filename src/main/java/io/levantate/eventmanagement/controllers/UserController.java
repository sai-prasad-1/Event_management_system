package io.levantate.eventmanagement.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.levantate.eventmanagement.models.User;
import io.levantate.eventmanagement.services.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> submitRegisterForm(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user: " + e.getMessage());
        }
    }

    @PostMapping("/login")
public ResponseEntity<Object> submitLoginForm(@RequestBody User user) {
    try {
        User loggedInUser = userService.login(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(loggedInUser);
    } catch (IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Failed to login user: " + e.getMessage());
    }
}


    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(){
        try{
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Login user: " + e.getMessage());
        }
    }
}
