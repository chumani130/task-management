package com.backend.taskmanagement.service;

import com.backend.taskmanagement.model.Task;
import com.backend.taskmanagement.model.User;

import java.util.List;

public interface TaskService {
    public Task createTask(Task task, User user);
    public Task findTaskById(Long id) throws Exception;

    public void deleteTask(Long id) throws Exception;

    public Task updateTask(Task task, Long id) throws Exception;

    public List<Task>findAllTask();

    public Task likeTask(Long taskId, User user) throws Exception;

    Task likTask(Long taskId, User user) throws Exception;
}
