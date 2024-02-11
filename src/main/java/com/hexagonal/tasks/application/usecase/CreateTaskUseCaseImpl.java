package com.hexagonal.tasks.application.usecase;

import com.hexagonal.tasks.domain.model.Task;
import com.hexagonal.tasks.domain.port.in.CreateTaskUseCase;
import com.hexagonal.tasks.domain.port.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }

}