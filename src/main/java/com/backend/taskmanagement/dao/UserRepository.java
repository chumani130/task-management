package com.backend.taskmanagement.dao;

import java.util.Optional;
import com.backend.taskmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}