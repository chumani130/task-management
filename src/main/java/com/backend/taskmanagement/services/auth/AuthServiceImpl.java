package com.backend.taskmanagement.services.auth;

import com.backend.taskmanagement.dto.SignupRequest;
import com.backend.taskmanagement.dto.UserDto;
import com.backend.taskmanagement.enums.UserRole;
import com.backend.taskmanagement.model.User;
import com.backend.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(SignupRequest signupRequest) {
        User user = new User();

        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        User createUser = userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setId(createUser.getId());

        return userDto;


    }
}
