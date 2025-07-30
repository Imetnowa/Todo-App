package com.springboot_todo_app.controllers;

import com.springboot_todo_app.DTO.TodoDTO;
import com.springboot_todo_app.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springboot_todo_app.service.TodoService;

import java.util.List;

@RestController
public class TodoItemController {
    @Autowired
    private TodoService service;

    public TodoItemController(TodoService service){
        this.service= service;
    }


    @GetMapping("/todos")
    public List<TodoItem> getAll(){
        return service.getAllTodos();
    }

    @PostMapping("/todos")
    public TodoItem create(@RequestBody TodoDTO todo){
        return service.addTodo(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteTodo(id);
    }
    @PutMapping("/{id}/toggle")
    public TodoItem toggle(@PathVariable Integer id){
        return service.toggleTodo(id);
    }
}
