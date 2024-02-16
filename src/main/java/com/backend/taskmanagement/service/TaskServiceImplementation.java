package com.backend.taskmanagement.service;

import com.backend.taskmanagement.model.Task;
import com.backend.taskmanagement.model.User;
import com.backend.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImplementation implements TaskService{
    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Task createTask(Task task, User user) {
        Task createTask = new Task();
        createTask.setTitle(task.getTitle());
        createTask.setImage(task.getImage());
        createTask.setDescription(task.getDescription());
        createTask.setUser(user);
        createTask.setCreatedAt(LocalDate.now());
        createTask.setPriority(task.getPriority());
        createTask.setCategory(task.getCategory());
        createTask.setCompleted(task.isCompleted());
        createTask.setDueDate(task.getDueDate());
        return taskRepository.save(createTask);
    }

    @Override
    public Task findTaskById(Long id) throws Exception {
        Optional<Task> opt = taskRepository.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }
        throw  new Exception("Task not found with id" +id);
    }

    @Override
    public void deleteTask(Long id) throws Exception {
        findTaskById(id);
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Task task, Long id) throws Exception {
        Task oldTask =findTaskById(id);
        if(task.getTitle()!=null) {
            oldTask.setTitle(task.getTitle());
        }
        if(task.getImage()!=null) {
            oldTask.setImage(task.getImage());
        }
        if(task.getDescription()!=null) {
            oldTask.setDescription(task.getDescription());
        }

        return taskRepository.save(oldTask);
    }

    @Override
    public List<Task> findAllTask() {

        return taskRepository.findAll();
    }
    @Override
    public Task likeTask(Long taskId, User user) throws Exception {
        Task task = findTaskById(taskId);

        // Check if the user ID is in the likes set
        if (task.getLikes().contains(user.getId())) {
            // User has already liked the task, remove the like
            task.getLikes().remove(user.getId());
        } else {
            // User is liking the task, add the like
            task.getLikes().add(user.getId());
        }

        // Update the likes count in the task
        task.setLikesCount(task.getLikes().size());

        return taskRepository.save(task);
    }
}
