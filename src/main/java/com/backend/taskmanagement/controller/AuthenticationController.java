package com.backend.taskmanagement.controller;

import com.backend.taskmanagement.dto.SignupRequestDTO;
import com.backend.taskmanagement.dto.UserDto;
import com.backend.taskmanagement.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthService authService;

    @PostMapping("/customer/sign-up")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequestDTO signupRequestDTO) {
        if(authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>("Customer already exist with this email", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser = authService.signupCustomer(signupRequestDTO);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @PostMapping("/admin/sign-up")
    public ResponseEntity<?> signupAdmin(@RequestBody SignupRequestDTO signupRequestDTO) {
        if(authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>("Admin already exist with this email", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser = authService.signupCustomer(signupRequestDTO);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
}