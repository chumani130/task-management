package com.backend.taskmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean completed;
    @ManyToOne
    private Task task;

}
