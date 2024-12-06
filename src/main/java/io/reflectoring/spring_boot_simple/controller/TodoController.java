package io.reflectoring.spring_boot_simple.controller;

import io.reflectoring.spring_boot_simple.dto.TodoDto;
import io.reflectoring.spring_boot_simple.model.Todo;
import io.reflectoring.spring_boot_simple.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> index(@RequestParam(value = "limit", required = false, defaultValue = "30") Integer limit) {
        return this.todoService.findAll(limit);
    }

    @PostMapping("/store")
    @ResponseStatus(HttpStatus.OK)
    public String addTodo(@RequestBody @Valid TodoDto todo) {
        todoService.add(todo);
        return "Create Successfully!";
    }

    @GetMapping("/detail/{todoId}")
    @ResponseStatus(HttpStatus.OK)
    public TodoDto getTodo(@PathVariable() String todoId) {
        return todoService.getTodo(todoId);

    }
}
