package com.backend.taskmanagement.dao;

import com.backend.taskmanagement.model.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {}