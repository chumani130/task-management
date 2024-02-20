package com.backend.taskmanagement.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private String email;
    private String userName;
}
