package com.hexagonal.tasks.infrastructure.adapter;

import com.hexagonal.tasks.domain.model.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.port.out.ExternalServicePort;
import com.hexagonal.tasks.infrastructure.dto.JsonPlaceHolderTodo;
import com.hexagonal.tasks.infrastructure.dto.JsonPlaceHolderUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        String apiUrl = BASE_URL.concat("todos/" + id);
        ResponseEntity<JsonPlaceHolderTodo> jsonPlaceHolderTodoResponseEntity = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo jsonPlaceHolderTodo = jsonPlaceHolderTodoResponseEntity.getBody();

        if (jsonPlaceHolderTodo == null) {
            return null;
        }

        apiUrl = BASE_URL.concat("users" + jsonPlaceHolderTodo.getUserId());
        ResponseEntity<JsonPlaceHolderUser> jsonPlaceHolderUserResponseEntity = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser jsonPlaceHolderUser = jsonPlaceHolderUserResponseEntity.getBody();

        if (jsonPlaceHolderUser == null) {
            return null;
        }

        return new AdditionalTaskInfo(jsonPlaceHolderTodo.getUserId(), jsonPlaceHolderUser.getName(), jsonPlaceHolderUser.getEmail());
    }

}
