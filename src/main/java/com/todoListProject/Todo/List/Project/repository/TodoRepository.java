package com.todoListProject.Todo.List.Project.repository;

import com.todoListProject.Todo.List.Project.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity,Long> {
}
