package com.backend.taskmanagement.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TaskRequest {
    @NotEmpty(message = "{task.category.not.empty}")
    private String category;

    @NotEmpty(message = "{task.title.not.empty}")
    private String title;

    @NotEmpty(message = "{task.priority.not.empty}")
    private String priority;

    @NotEmpty(message = "{task.description.not.empty}")
    private String description;

    @NotNull(message = "{task.dateCreated.not.null}")
    private String dateCreated;

    @NotNull(message = "{task.endDate.not.null}")
    private LocalDate endDate;

    @NotNull(message = "{task.subtasks.not.null}")
    @Size(min = 5, message = "{task.subtasks.size}")
    private List<String> subTasks;

    private boolean allowNotification;

    public TaskRequest() {
        // Default constructor
    }

    public TaskRequest(String title, String category, String priority, String description, List<String> subtasks,
                       String endDate, String dateCreated, boolean allowNotification) {
        this.title = title;
        this.category = category;
        this.priority = priority;
        this.description = description;
        this.subTasks = subtasks;
        this.endDate = LocalDate.parse(endDate);
        this.dateCreated = String.valueOf(LocalDate.parse(dateCreated));
        this.allowNotification = allowNotification;
    }


}