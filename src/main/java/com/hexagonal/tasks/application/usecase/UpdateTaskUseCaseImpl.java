package com.hexagonal.tasks.application.usecase;

import com.hexagonal.tasks.domain.model.Task;
import com.hexagonal.tasks.domain.port.in.UpdateTaskUseCase;
import com.hexagonal.tasks.domain.port.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }

}
