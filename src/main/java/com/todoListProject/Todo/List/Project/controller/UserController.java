package com.todoListProject.Todo.List.Project.controller;

import com.todoListProject.Todo.List.Project.entity.UserEntity;
import com.todoListProject.Todo.List.Project.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public void createUser(@RequestBody UserEntity user){userServices.save(user);
    }

    @GetMapping
    public List<UserEntity> getAllUser(){
        return userServices.getAll();
    }


    @GetMapping("/id/{id}")
    public UserEntity getUser(@PathVariable Long id){
        return userServices.getById(id);
    }

    @GetMapping("/username/{username}")
    public UserEntity getUserByUsername(@PathVariable String username){
        return userServices.getByUsername(username);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Long id){
        return userServices.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user){
        return userServices.updateUser(id, user);
    }


}
