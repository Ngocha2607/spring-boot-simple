package io.reflectoring.spring_boot_simple.service;

import io.reflectoring.spring_boot_simple.dto.TodoDto;
import io.reflectoring.spring_boot_simple.model.Todo;
import io.reflectoring.spring_boot_simple.model.TodoValidator;
import io.reflectoring.spring_boot_simple.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final ModelMapper mapper;

    private final TodoRepository todoRepository;

    private final TodoValidator todoValidator;

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

    public TodoDto getTodo(String todoId) {

        Todo todo = todoRepository.findById(todoId).orElseThrow();

        return mapper.map(todo, TodoDto.class);
    }
}
