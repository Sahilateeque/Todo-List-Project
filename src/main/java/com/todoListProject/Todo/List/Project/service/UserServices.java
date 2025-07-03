package com.todoListProject.Todo.List.Project.service;
import com.todoListProject.Todo.List.Project.entity.UserEntity;
import com.todoListProject.Todo.List.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public void save(UserEntity user){
        user.setLocalDateTime(LocalDateTime.now());
        userRepository.save(user);
    }

    public List<UserEntity> getAll(){
        return  userRepository.findAll();
    }

    public UserEntity getById(Long id){
        return  userRepository.findById(id).orElse(null);
    }

    public UserEntity getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity updateUser(Long id,UserEntity newUser){
        UserEntity oldUser = userRepository.findById(id).orElse(null);

        if(oldUser != null){

            if (!newUser.getUsername().isEmpty()) {
                oldUser.setUsername(newUser.getUsername());
            }
            if (!newUser.getPassword().isEmpty()) {
                oldUser.setPassword(newUser.getPassword());
            }

            userRepository.save(oldUser);


        }
        return oldUser;
    }

    public boolean deleteById(Long id){
        userRepository.deleteById(id);
        return true;
    }


}
