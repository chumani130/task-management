package com.backend.taskmanagement.dto;

import com.backend.taskmanagement.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private UserRole userRole;
}
