package com.todoListProject.Todo.List.Project.service;

import com.todoListProject.Todo.List.Project.entity.TodoEntity;
import com.todoListProject.Todo.List.Project.entity.UserEntity;
import com.todoListProject.Todo.List.Project.repository.TodoRepository;
import com.todoListProject.Todo.List.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    // create

    public TodoEntity save(TodoEntity todo, String username) {
        todo.setLocalDateTime(LocalDateTime.now());

        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found with username: " + username);
        }

        todo.setUser(user);

        return todoRepository.save(todo);
    }


    public List<TodoEntity> getAll(String username){
        UserEntity user = userRepository.findByUsername(username);
        return  user.getTodoList();
    }

    public TodoEntity getById(long id){
        return todoRepository.findById(id).orElse(null);
    }

    //update
    public TodoEntity updateTodo(long id, TodoEntity newTodo){
        TodoEntity oldTodo = todoRepository.findById(id).orElse(null);

        if(oldTodo != null){
            oldTodo.setTitle( !newTodo.getTitle().isEmpty() ? newTodo.getTitle():oldTodo.getTitle());

            oldTodo.setDescription(newTodo.getDescription() != null && !newTodo.getDescription().isEmpty()?newTodo.getDescription():oldTodo.getDescription());

            todoRepository.save(oldTodo);

        }
        return oldTodo;
    }

    // delete
    public boolean deleteById(long id){
        todoRepository.deleteById(id);
        return true;
    }
}
