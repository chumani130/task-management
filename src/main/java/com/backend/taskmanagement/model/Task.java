//package com.backend.taskmanagement.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Getter
//@Setter
//@Entity
//public class Task {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String title;
//
//    @ManyToOne
//    private User user;
//
//    private String category;
//
//    private String priority;
//
//    private String image;
//
//    private String description;
//    private String todolist;
//    private boolean completed;
//    private LocalDate dueDate;
//    private LocalDate createdAt;
//
//    @ElementCollection
//    private Set<Long> likes = new HashSet<>();
//
//    private int likesCount;
//
//}