package com.customerService.repository;

import com.customerService.model.Customer;
import com.customerService.model.User;
import com.customerService.repository.mapper.CustomerMapper;
import com.customerService.repository.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private static final String USER_TABLE_NAME = "user";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public Long createUser(User user) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name, last_name, email, age, address, joining_date) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(),user.getAddress(),user.getJoiningDate());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public User getUserById(Long userId) throws JsonProcessingException {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
        try {
            User userFromDB = jdbcTemplate.queryForObject(sql, new UserMapper(), userId);
            String userAsString = objectMapper.writeValueAsString(userFromDB);
            return userFromDB;
        } catch (EmptyResultDataAccessException error){
            return null;
        }
       // return null;
    }

    @Override
    public void updateUserById(Long userId,User user) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=?, email=? ,age=?,address=?,joining_date=?" +
                "WHERE id=?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(),user.getAddress(),user.getJoiningDate(), userId);
    }

    @Override
    public void deleteUserById(Long userId) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, userId);
    }
}
