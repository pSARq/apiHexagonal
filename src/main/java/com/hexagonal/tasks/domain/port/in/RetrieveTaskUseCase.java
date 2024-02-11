package com.hexagonal.tasks.domain.port.in;

import com.hexagonal.tasks.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {

    Optional<Task> getTaskById(Long id);

    List<Task> getAllTasks();

}
