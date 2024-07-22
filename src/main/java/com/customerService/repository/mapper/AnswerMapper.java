package com.customerService.repository.mapper;

import com.customerService.model.Answer;
import com.customerService.model.Customer;
import com.customerService.model.CustomerStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerMapper implements RowMapper<Answer> {

    @Override
    public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Answer(
                rs.getLong("question_id"),
                rs.getLong("user_id"),
                rs.getInt("answer_id")
        );
    }
}