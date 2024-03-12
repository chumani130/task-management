package com.backend.taskmanagement.services.auth;

import com.backend.taskmanagement.dto.SignupRequestDTO;
import com.backend.taskmanagement.dto.UserDto;
import com.backend.taskmanagement.entity.UserEntity;
import com.backend.taskmanagement.enums.UserRole;
import com.backend.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto signupCustomer(SignupRequestDTO signupRequestDTO) {
        UserEntity user = new UserEntity();

        user.setUsername(signupRequestDTO.getUsername());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.CUSTOMER);

        return userRepository.save(user).getDto();
    }

    @Override
    public UserDto signupAdmin(SignupRequestDTO signupRequestDTO) {
        UserEntity user = new UserEntity();

        user.setUsername(signupRequestDTO.getUsername());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.ADMIN);

        return userRepository.save(user).getDto();
    }

    @Override
    public Boolean presentByEmail(String email) {
        return null;
    }
}
