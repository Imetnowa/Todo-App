package com.springboot_todo_app.Repository;

import com.springboot_todo_app.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem,Integer> {
}
