package com.backend.taskmanagement.dao;

import com.backend.taskmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String user);
}
