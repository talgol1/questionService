package com.customerService.service;

import com.customerService.model.Question;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface QuestionService {
    Long createQuestion (Question question) throws Exception;
    Question getQuestionById(Long id) throws JsonProcessingException;
    void updateQuestionById (Long id, Question question);
    void deleteQuestionById(Long id);
}
