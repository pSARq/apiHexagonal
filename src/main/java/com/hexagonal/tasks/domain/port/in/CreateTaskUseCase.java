package com.hexagonal.tasks.domain.port.in;

import com.hexagonal.tasks.domain.model.Task;

public interface CreateTaskUseCase {

    Task createTask(Task task);

}
