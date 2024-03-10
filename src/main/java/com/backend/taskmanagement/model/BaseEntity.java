package com.backend.taskmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Override
    public boolean equals(Object other) {
        if (other instanceof BaseEntity baseEntity) {
            return Objects.nonNull(id) && Objects.equals(id, baseEntity.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.isNull(id) ? 0 : id.hashCode();
    }

    @NotNull
    @Column(name = "creation_timestamp")
    private LocalDateTime creationTimestamp;

    @Column(name = "modification_timestamp")
    private LocalDateTime modificationTimestamp;

    @PrePersist
    protected void setCreationParameters() {
        creationTimestamp = LocalDateTime.now();
        version = 0;
    }

    @PreUpdate
    private void modificationAt() {
        modificationTimestamp = LocalDateTime.now();
    }

}