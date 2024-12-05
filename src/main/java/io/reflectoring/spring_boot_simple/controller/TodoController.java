package io.reflectoring.spring_boot_simple.controller;

import io.reflectoring.spring_boot_simple.dto.TodoDto;
import io.reflectoring.spring_boot_simple.model.Todo;
import io.reflectoring.spring_boot_simple.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping()
    public List<Todo> index(@RequestParam(value = "limit", required = false) Integer limit) {
        return this.todoService.findAll(limit);
    }

    @PostMapping("/addTodo")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        todoService.add(todo);

        return ResponseEntity.ok().body(todo);
    }

    @GetMapping("/detail/{todoId}")
    public TodoDto getTodo(@PathVariable() String todoId) {
        return todoService.getTodo(todoId);

    }
}
