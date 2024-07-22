package com.customerService.model;

public class Answer {
    private Long questionId;
    private Long userId;
    private int answer;

    public Answer(Long questionId, Long userId, int answer) {
        this.questionId = questionId;
        this.userId = userId;
        this.answer = answer;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public Long getUserId() {
        return userId;
    }

    public int getAnswer() {
        return answer;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
