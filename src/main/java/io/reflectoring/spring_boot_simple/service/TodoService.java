package io.reflectoring.spring_boot_simple.service;

import io.reflectoring.spring_boot_simple.model.Todo;
import io.reflectoring.spring_boot_simple.model.TodoValidator;
import io.reflectoring.spring_boot_simple.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoValidator todoValidator;

    public List<Todo> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> todoRepository.findAll());
    }


    public Todo add(Todo todo) {
        if(todoValidator.isValid(todo)) {
            return todoRepository.save(todo);
        }
        return null;
    }

    public Todo getTodo(String todoId) {
        return todoRepository.getById(todoId);
    }
}
