package com.hexagonal.tasks.infrastructure.entity;

import com.hexagonal.tasks.domain.model.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String tittle, String description, LocalDateTime creationDate, boolean completed) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.creationDate = creationDate;
        this.completed = completed;
    }

    //Esto es un mapper, normalmente tiene su propio paquete con sus clases propias para el mappeo
    public static TaskEntity fromDomainModel(Task task){
        return new TaskEntity(
                task.getId(),
                task.getTittle(),
                task.getDescription(),
                task.getCreationDate(),
                task.isCompleted()
                );
    }

    public Task toDomainModel(){
        return new Task(
                this.id,
                this.tittle,
                this.description,
                this.creationDate,
                this.completed
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
