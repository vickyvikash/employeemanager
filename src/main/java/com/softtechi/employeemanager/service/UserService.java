package com.softtechi.employeemanager.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.softtechi.employeemanager.dao.UserRepository;
// import com.softtechi.employeemanager.exception.UserNotFoundException;
import com.softtechi.employeemanager.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    //add new user
    public User addUser(User user){
        user.setAccesstoken(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

    //get all users
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    //get user by id
    public Optional<User> getUserById(Long id){
        return userRepo.findUserById(id);
        //.orElseThrow(() -> new UserNotFoundException("User by id "+ id + "was not found"));
    }

    //update user by id
    public User updateUser(User user){
        return userRepo.save(user);
    }

    //delete user by id
    public void deleteUserById(Long id){
        userRepo.deleteUserById(id);
    }

}
