package com.hexagonal.tasks.infrastructure.config;

import com.hexagonal.tasks.application.service.TaskService;
import com.hexagonal.tasks.application.usecase.*;
import com.hexagonal.tasks.domain.port.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.port.out.ExternalServicePort;
import com.hexagonal.tasks.domain.port.out.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.adapter.ExternalServiceAdapter;
import com.hexagonal.tasks.infrastructure.repository.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }

}
