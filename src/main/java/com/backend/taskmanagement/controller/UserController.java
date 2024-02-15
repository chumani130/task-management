package com.backend.taskmanagement.controller;

import com.backend.taskmanagement.model.User;
import com.backend.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception{
        User isExist = userRepository.findByEmail(user.getEmail());
        if(isExist!=null) {
            throw new Exception("User is exist with "+user.getEmail());
        }

        User saveUser = userRepository.save(user);

        return saveUser;
    }
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) throws Exception{
        userRepository.deleteById(userId);

        return "User deleted successfully";

    }
    @GetMapping("/users")
    public List<User> getAllUser() throws Exception{
        List<User> users = userRepository.findAll();

        return users;
    }




//    public User findByEmail(String email) throws Exception{
//        User user = userRepository.findByEmail(email);
//        if(user==null) {
//            throw new Exception("User not found with email "+email);
//        }
//        return user;
//    }
}
