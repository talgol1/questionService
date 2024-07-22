package com.customerService.service;

import com.customerService.model.Question;
import com.customerService.repository.QuestionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long createQuestion(Question question) throws Exception {
        return questionRepository.createQuestion(question);
    }

    @Override
    public Question getQuestionById(Long id) throws JsonProcessingException {
        return questionRepository.getQuestionById(id);
    }

    @Override
    public void updateQuestionById(Long id, Question question) {
        questionRepository.updateQuestionById(id, question);
    }

    @Override
    public void deleteQuestionById(Long id) {
        questionRepository.deleteQuestionById(id);
    }
}
