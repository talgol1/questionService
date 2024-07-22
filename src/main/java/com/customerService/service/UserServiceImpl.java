package com.customerService.service;

import com.customerService.model.User;
import com.customerService.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    ObjectMapper objectMapper;
    @Override
    public Long createUser(User user) throws Exception {
        return userRepository.createUser(user);
    }

    @Override
    public void updateUserById(Long userId, User user) throws Exception {
        userRepository.updateUserById(userId,user);
    }

    @Override
    public void deleteUserById(Long userId) throws Exception {
        userRepository.deleteUserById(userId);
    }

    @Override
    public User getUserById(Long userId) throws JsonProcessingException {
       return userRepository.getUserById(userId);
    }
}
