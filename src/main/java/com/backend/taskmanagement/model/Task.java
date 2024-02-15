package com.backend.taskmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne
    private User user;

    private String category;

    private String priority;

    private String image;

    private String description;
    private String todolist;
    private boolean completed;
    private LocalDate dueDate;
    private LocalDate createdAt;

    private List<Long> likes = new ArrayList<>();



}
