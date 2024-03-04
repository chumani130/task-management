package com.backend.taskmanagement.services;

import com.backend.taskmanagement.dao.UserRepository;
import com.backend.taskmanagement.model.User;
import com.backend.taskmanagement.model.RegisterUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User createUser(RegisterUser registerUser) {
        User user = new User();
        user.setName(registerUser.getName());
        user.setEmail(registerUser.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.getPassword()));
        // Add other fields as necessary
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String updateUserById(Long id, RegisterUser registerUser) {
        User user = getUserById(id);
        if (user == null) {
            return "User not found";
        }
        user.setName(registerUser.getName());
        user.setEmail(registerUser.getEmail());
        // Update other fields as necessary
        userRepository.save(user);
        return "User updated successfully";
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean isUserEmailPresent(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
