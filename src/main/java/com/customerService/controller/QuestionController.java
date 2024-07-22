package com.customerService.controller;

import com.customerService.model.Question;
import com.customerService.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping(value = "/question/create")
    public Long createQuestion(@RequestBody Question question) throws Exception{
        return questionService.createQuestion(question);
    }
    @PutMapping(value = "/question/{id}/update")
    public void updateQuestionById(@PathVariable Long id,
                                   @RequestBody Question question) throws Exception {
        questionService.updateQuestionById(id,question);
    }
    @DeleteMapping(value = "/question/{id}/delete")
    public void deleteUserById(@PathVariable Long id) throws Exception {
        questionService.deleteQuestionById(id);
    }
    @GetMapping(value = "/question/{id}")
    public Question getQuestionById(@PathVariable Long id) throws JsonProcessingException {
        return questionService.getQuestionById(id);
    }


}
