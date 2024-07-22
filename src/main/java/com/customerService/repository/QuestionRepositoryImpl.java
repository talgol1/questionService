package com.customerService.repository;

import com.customerService.model.Question;
import com.customerService.repository.mapper.QuestionMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository{
    private static final String QUESTION_TABLE_NAME = "question";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long createQuestion(Question question) {
        String sql = "INSERT INTO " + QUESTION_TABLE_NAME + " (id, question, first_answer, second_answer, third_answer, fourth_answer) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, question.getId(), question.getQuestion(), question.getFirstAnswer(), question.getSecondAnswer(), question.getThirdAnswer(),question.getFourthAnswer());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public Question getQuestionById(Long id) throws JsonProcessingException {
        String sql = "SELECT * FROM " + QUESTION_TABLE_NAME + " WHERE id=?";
        try {
            Question questionFromDB = jdbcTemplate.queryForObject(sql, new QuestionMapper() ,id);
            String questionAsString = objectMapper.writeValueAsString(questionFromDB);
            return questionFromDB;
        } catch (EmptyResultDataAccessException error) {

            return null;
        }
    }


    @Override
    public void updateQuestionById(Long id, Question question) {
        String sql = "UPDATE " + QUESTION_TABLE_NAME + " SET question=?, first_answer=?, second_answer=? ,third_answer=?,fourth_answer=? " +
                "WHERE id=?";
        jdbcTemplate.update(sql, question.getQuestion(), question.getFirstAnswer(), question.getSecondAnswer(), question.getThirdAnswer(),question.getFourthAnswer(),id);
    }

    @Override
    public void deleteQuestionById(Long id) {
        String sql = "DELETE FROM " + QUESTION_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);

    }
}
