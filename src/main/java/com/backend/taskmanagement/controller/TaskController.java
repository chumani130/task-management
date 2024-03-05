package com.backend.taskmanagement.controller;

import com.backend.taskmanagement.model.Task;
import com.backend.taskmanagement.model.TaskRequest;
import com.backend.taskmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody TaskRequest taskRequest, Principal principal) {
        // You can create a TaskRequest class to encapsulate the incoming data
        Task task = taskService.createTask(taskRequest, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/alltasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Task>> getTasksInCategory(@PathVariable String categoryName) {
        List<Task> tasks = taskService.getTasksInCategory(categoryName);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        // Retrieve the existing task from the database
        Task existingTask = taskService.getTaskById(id);
        if (existingTask == null) {
            // If the task doesn't exist, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }

        // Update the fields of the existing task with the new values
        existingTask.setName(updatedTask.getName());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        // Add other fields as necessary

        // Save the updated task back to the database
        taskService.updateTask(existingTask);

        // Return the updated task
        return ResponseEntity.ok(existingTask);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
