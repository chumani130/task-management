package com.backend.taskmanagement.model;

import com.backend.taskmanagement.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String email;
    private String userName;
    private UserRole role;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;
}
