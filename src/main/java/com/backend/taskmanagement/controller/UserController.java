package com.backend.taskmanagement.controller;

import com.backend.taskmanagement.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
    return user;
    }
}
