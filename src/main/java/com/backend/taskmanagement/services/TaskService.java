package com.backend.taskmanagement.services;

import com.backend.taskmanagement.model.Task;
import com.backend.taskmanagement.model.TaskRequest;
import com.backend.taskmanagement.model.SubTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskRequest taskRequest) {
        Task task = mapTaskRequestToTask(taskRequest);
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

    public Task updateTask(Long id, TaskRequest taskRequest) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            mapTaskRequestToTask(taskRequest, existingTask);
            taskRepository.save(existingTask);
        }
        return existingTask;
    }
    public Task mapTaskRequestToTask(TaskRequest taskRequest, Task task) {
        task.setName(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setCompleted(false); // You might want to set this based on your requirements
        task.setDate(LocalDate.parse(taskRequest.getDateCreated()));
        // Set other properties as needed

        // Map subtasks
        List<SubTask> subTasks = taskRequest.getSubTasks().stream()
                .map(subTaskDescription -> new SubTask(subTaskDescription))
                .collect(Collectors.toList());
        task.setSubTasks(subTasks);

        return task;
    }

}
