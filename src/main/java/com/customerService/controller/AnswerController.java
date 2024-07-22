package com.customerService.controller;

import com.customerService.model.Answer;
import com.customerService.model.User;
import com.customerService.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @PostMapping(value = "/answer/create")
    public void createUser(@RequestBody Answer answer) throws Exception{
        answerService.createAnswer(answer);
    }
    @GetMapping(value="/answer/{userId}/showAll")
    public List<Answer> getAllAnswersByUserId(@PathVariable Long userId) throws Exception{
        return answerService.getAllAnswersByUserId(userId);
    }


    @DeleteMapping(value = "/answer/{userId}/deleteAll")
    public void deleteAllAnswersByUserId(@PathVariable Long userId) throws Exception {
        answerService.deleteAllAnswersByUser(userId);
    }
}
