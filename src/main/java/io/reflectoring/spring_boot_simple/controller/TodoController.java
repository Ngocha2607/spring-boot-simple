package io.reflectoring.spring_boot_simple.controller;

import io.reflectoring.spring_boot_simple.model.Todo;
import io.reflectoring.spring_boot_simple.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/listTodo")
    public List<Todo> index(@RequestParam(value = "limit", required = false) Integer limit) {
        return this.todoService.findAll(limit);
    }

    @PostMapping("/addTodo")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        todoService.add(todo);

        return ResponseEntity.ok().body(todo);
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable() String todoId) {
        return todoService.getTodo(todoId);

    }
}
