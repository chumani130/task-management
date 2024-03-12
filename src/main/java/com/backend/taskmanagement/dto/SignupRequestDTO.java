package com.backend.taskmanagement.dto;

import lombok.Data;

@Data
public class SignupRequestDTO {
    private Long id;
    private String email;
    private String password;
    private String username;
}
