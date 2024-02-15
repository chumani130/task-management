package com.backend.taskmanagement.controller;

import com.backend.taskmanagement.model.Task;
import com.backend.taskmanagement.model.User;
import com.backend.taskmanagement.service.TaskService;
import com.backend.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/api/task")
    public List<Task> getAllTask() throws Exception {
        List<Task> tasks = taskService.findAllTask();
        return tasks;
    }
    public


}
