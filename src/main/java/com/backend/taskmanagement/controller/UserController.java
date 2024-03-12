//package com.backend.taskmanagement.controller;
//
//import com.backend.taskmanagement.model.RegisterUser;
//import com.backend.taskmanagement.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/user")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/addUser")
//    public ResponseEntity<String> addUser(@RequestBody RegisterUser registerUser){
//        return ResponseEntity.ok(userService.createUser(registerUser));
//    }
//
//    @GetMapping("/getAllUsers")
//    public ResponseEntity<List<User>> getAllUsers(){
//        List<User> users = userService.getAllUsers();
//        return ResponseEntity.ok(users);
//    }
//
//    @GetMapping("/getUserById/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
//        User user = userService.getUserById(id);
//        return ResponseEntity.ok(user);
//    }
//
//    @PutMapping("/updateUserById/{id}")
//    public ResponseEntity<String> updateUserById(@PathVariable("id") Long id, @RequestBody RegisterUser registerUser){
//        return ResponseEntity.ok(userService.updateUserById(id, registerUser));
//    }
//
//    @DeleteMapping("/deleteUserById/{id}")
//    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
//        userService.deleteUserById(id);
//        return ResponseEntity.ok("User deleted successfully");
//    }
//}
