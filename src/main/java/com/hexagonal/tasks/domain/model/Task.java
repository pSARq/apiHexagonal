package com.hexagonal.tasks.domain.model;


import java.time.LocalDateTime;

public class Task {

    private Long id;
    private String tittle;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

    public Task(Long id, String tittle, String description, LocalDateTime creationDate, boolean completed) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.creationDate = creationDate;
        this.completed = completed;
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
