package com.backend.taskmanagement.services.auth;

import com.backend.taskmanagement.dto.SignupRequest;
import com.backend.taskmanagement.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);
}
