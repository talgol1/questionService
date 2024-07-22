package com.customerService.repository;

import com.customerService.model.Answer;
import com.customerService.model.User;
import com.customerService.repository.mapper.AnswerMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository {
    private static final String ANSWER_TABLE_NAME = "answer";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void createAnswer(Answer answer) {
        String sql = "INSERT INTO " + ANSWER_TABLE_NAME + " (question_id, user_id, answer_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, answer.getQuestionId(), answer.getUserId(), answer.getAnswer());
    }

    @Override
    public void deleteAllAnswersByUser(Long userId) {
        String sql = "DELETE FROM " + ANSWER_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public List<Answer> getAllAnswersByUserId(Long userId) {
        String sql = "SELECT * FROM " + ANSWER_TABLE_NAME + " WHERE user_id=?";
        try {
            return jdbcTemplate.query(sql, new AnswerMapper(), userId);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}