package com.customerService.service;

import com.customerService.model.Answer;
import com.customerService.model.User;

import java.util.List;

public interface AnswerService {
    void createAnswer(Answer answer);
    void deleteAllAnswersByUser(Long userId);
    List<Answer>getAllAnswersByUserId(Long userId);
}
