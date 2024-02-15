package com.backend.taskmanagement.controller;

import com.backend.taskmanagement.model.Task;
import com.backend.taskmanagement.model.User;
import com.backend.taskmanagement.service.TaskService;
import com.backend.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @PostMapping("/api/task/user/{userId}")
    public Task createTask(@RequestBody Task task, @PathVariable Long userId) throws Exception{

        User user = userService.findUserById(userId);

        Task createdTask = taskService.createTask(task, user);
        return createdTask;
    }

}
