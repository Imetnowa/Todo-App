package com.springboot_todo_app.service;

import com.springboot_todo_app.DTO.TodoDTO;
import com.springboot_todo_app.Repository.TodoRepository;
import com.springboot_todo_app.model.TodoItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    List<TodoItem> todoItems = new ArrayList<>(Arrays.asList(
            new TodoItem(0, "Shower",false),
            new TodoItem(1, "Make breakfast", false),
            new TodoItem(2, "Dress up for work", false),
            new TodoItem(3, "Go to work", false)));

    public TodoService(TodoRepository repository){
        this.repository = repository;
    }
    public List<TodoItem> getAllTodos(){
        return repository.findAll();

    }
    public TodoItem addTodo(TodoDTO todo){
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle(todo.getTitle());
        todoItem.setCompleted(todo.isCompleted());
        return repository.save(todoItem);
    }
    public void deleteTodo(Integer id){
        repository.deleteById(Math.toIntExact(id));
    }
    public TodoItem toggleTodo(Integer id){
        TodoItem todo = repository.findById(Math.toIntExact(id)).orElseThrow();
        todo.setCompleted(!todo.isCompleted());
        return repository.save(todo);
    }
}
