package com.backend.taskmanagement.services;

import com.backend.taskmanagement.dao.TaskRepository;
import com.backend.taskmanagement.model.Task;
import com.backend.taskmanagement.model.TaskRequest;
import com.backend.taskmanagement.model.SubTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskRequest taskRequest) {
        Task task = new Task();
        // Set task properties using taskRequest
        task.setCategory(taskRequest.getCategory());
        task.setTitle(taskRequest.getTitle());
        task.setPriority(taskRequest.getPriority());
        task.setDescription(taskRequest.getDescription());
        task.setEndDate(taskRequest.getEndDate());
        task.setDateCreated(taskRequest.getDateCreated());
        task.setAllowNotification(taskRequest.isAllowNotification());

        List<SubTask> subTasks = taskRequest.getSubTasks();
        if (subTasks.size() >= 5) {
            subTasks.forEach(task::addSubTask);
        } else {
            // Add logic to handle when fewer than five subtasks are provided
            // For example, you can throw an exception or add default subtasks
            throw new IllegalArgumentException("At least five subtasks are required.");
        }

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksInCategory(String categoryName) {
        return taskRepository.findByCategoryName(categoryName);
    }
}
