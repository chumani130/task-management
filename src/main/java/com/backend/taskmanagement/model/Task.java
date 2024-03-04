package com.backend.taskmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    @NotEmpty(message = "{task.name.not.empty}")
    private String name;
    @NotEmpty(message = "{task.description.not.empty}")
    @Column(length = 1200)
    @Size(max = 1200, message = "{task.description.size}")
    private String description;
    @NotNull(message = "{task.date.not.null}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private boolean isCompleted;
    @ManyToOne
    private TaskCategory category;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubTask> subTasks = new ArrayList<>();

    public long daysLeftUntilDeadline(LocalDate date) {
        return ChronoUnit.DAYS.between(LocalDate.now(), date);
    }

    public Task() {
    }
    public Task(@NotEmpty String name,
                @NotEmpty @Size(max = 1200) String description,
                @NotNull LocalDate date,
                boolean isCompleted)
                {
        this.name = name;
        this.description = description;
        this.date = date;
        this.isCompleted = isCompleted;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isCompleted == task.isCompleted &&
                Objects.equals(id, task.id) &&
                name.equals(task.name) &&
                description.equals(task.description) &&
                date.equals(task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, date, isCompleted);
    }

}

