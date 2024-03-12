package com.backend.taskmanagement.services.auth;

import com.backend.taskmanagement.dto.SignupRequestDTO;
import com.backend.taskmanagement.dto.UserDto;

public interface AuthService {
    UserDto signupCustomer(SignupRequestDTO signupRequestDTO);
    UserDto signupAdmin(SignupRequestDTO signupRequestDTO);


    Boolean presentByEmail(String email);
}
