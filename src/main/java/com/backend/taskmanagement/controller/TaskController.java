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
    @DeleteMapping("api/task/{taskId}")
    public String deleteTask(@PathVariable Long taskId) throws Exception {
        taskService.deleteTask(taskId);
        return "task deleted successfully";
    }
    @PutMapping("/api/task/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id) throws Exception {
        Task updatedTask = taskService.updateTask(task, id);
        return updatedTask;
    }
    
    @PutMapping("/api/task/{taskId}/user/{userId}/like")
    public Task likeTask(@PathVariable Long userId, @PathVariable Long taskId) throws Exception {
        User user = userService.findUserById(userId);
        Task updatedTask = taskService.likeTask(taskId, user);
        return updatedTask;
}


}
