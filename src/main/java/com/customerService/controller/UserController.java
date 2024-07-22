package com.customerService.controller;

import com.customerService.model.Customer;
import com.customerService.model.User;
import com.customerService.repository.UserRepository;
import com.customerService.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/user/create")
    public Long createUser(@RequestBody User user) throws Exception{
        return userService.createUser(user);


    }
    @PutMapping(value = "/user/{userId}/update")
    public void updateUserById(@PathVariable Long userId,
                                   @RequestBody User user) throws Exception {
        userService.updateUserById(userId, user);
    }
    @DeleteMapping(value = "/user/{userId}/delete")
    public void deleteUserById(@PathVariable Long userId) throws Exception {
        userService.deleteUserById(userId);
    }
    @GetMapping(value = "/user/{userId}")
    public User getUserById(@PathVariable Long userId) throws JsonProcessingException {
        return userService.getUserById(userId);
    }
    @GetMapping(value="/testController")
    public String testController(){
        return "Controller is working properly";
    }
}
