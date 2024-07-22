package com.customerService.repository.mapper;

import com.customerService.model.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Question(
                rs.getLong("id"),
                rs.getString("question"),
                rs.getString("firstAnswer"),
                rs.getNString("secondAnswer"),
                rs.getString("thirdAnswer"),
                rs.getString("fourthAnswer")

        );
    }
}
