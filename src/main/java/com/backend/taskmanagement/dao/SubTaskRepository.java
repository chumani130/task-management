package com.backend.taskmanagement.dao;

import com.backend.taskmanagement.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {}