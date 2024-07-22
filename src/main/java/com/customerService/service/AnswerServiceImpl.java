package com.customerService.service;

import com.customerService.model.Answer;
import com.customerService.model.User;
import com.customerService.repository.AnswerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createAnswer(Answer answer) {
        answerRepository.createAnswer(answer);
    }

    @Override
    public void deleteAllAnswersByUser(Long userId) {
        answerRepository.deleteAllAnswersByUser(userId);
    }

    @Override
    public List<Answer> getAllAnswersByUserId(Long userId) {
        return answerRepository.getAllAnswersByUserId(userId);
    }
}

