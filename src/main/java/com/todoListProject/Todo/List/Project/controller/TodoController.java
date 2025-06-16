package com.todoListProject.Todo.List.Project.controller;

import com.todoListProject.Todo.List.Project.entity.TodoEntity;
import com.todoListProject.Todo.List.Project.entity.UserEntity;
import com.todoListProject.Todo.List.Project.repository.UserRepository;
import com.todoListProject.Todo.List.Project.service.TodoService;
import com.todoListProject.Todo.List.Project.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create/{username}")
    public ResponseEntity<TodoEntity> createTodo(@PathVariable String username, @RequestBody TodoEntity todo){
        try {
            TodoEntity savedTodo =  todoService.save(todo,username);
            return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
        } catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetch/{username}")
    public  ResponseEntity<List<TodoEntity>> getAllTodos(@PathVariable String username){
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // clearer and RESTful
        }


        return ResponseEntity.ok(user.getTodoList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoEntity> getTodo(@PathVariable long id){
        TodoEntity todo =  todoService.getById(id);
        if(todo!=null){
            return ResponseEntity.status(200).body(todo);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteTodo(@PathVariable long  id){
        return todoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public TodoEntity updateTodo(@PathVariable long id, @RequestBody TodoEntity todo){
        return todoService.updateTodo(id, todo);
    }

}