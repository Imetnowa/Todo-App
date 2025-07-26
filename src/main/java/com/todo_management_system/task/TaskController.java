package com.todo_management_system.task;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/add")
    public TaskItem addTask(@Valid @RequestBody TaskItem taskItem) {
        return taskRepository.save(taskItem);


    }

    @GetMapping
    public List<TaskItem> getAllTasks() {
        return taskRepository.findAll();

    }

}