package com.softtechi.employeemanager.controller;

import java.util.List;
import java.util.Optional;

// import com.softtechi.employeemanager.dao.UserRepository;
import com.softtechi.employeemanager.model.User;
import com.softtechi.employeemanager.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        try {
            List<User> users = userService.getAllUsers();
            return new ResponseEntity<>(users,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        try {
            Optional<User> user = userService.getUserById(id);
            if(user.isPresent()){
                return new ResponseEntity<>(user.get(), HttpStatus.OK);
            } 
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<User> addEmployee(@RequestBody User user){
        try {
            User newUser = userService.addUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        try {
            Optional<User> userFound = userService.getUserById(id);
            if(userFound.isPresent()){
                // User updateUser = userService.updateUser(user);
                // return new ResponseEntity<>(updateUser, HttpStatus.OK);
                User _user = userFound.get();
                _user.setUsername(user.getUsername());
                _user.setPassword(user.getPassword());;
                // _user.setAccesstoken(user.getAccesstoken());;
                return new ResponseEntity<>(userService.updateUser(_user), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        // return new ResponseEntity<>(HttpStatus.OK);
    }

}
