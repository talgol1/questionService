package com.customerService.repository;

import com.customerService.model.Question;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface QuestionRepository {
    Long createQuestion(Question question);
    Question getQuestionById(Long id) throws JsonProcessingException;
    void updateQuestionById (Long id, Question question);
    void deleteQuestionById(Long id);
}
