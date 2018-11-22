package com.eagleshing.miniprogram.domain.question;

import com.eagleshing.miniprogram.domain.UserAnswer;
import com.eagleshing.miniprogram.domain.UserQuestion;
import com.eagleshing.miniprogram.domain.type.QuestionType;

import java.util.List;

public class QuestionResponse {

    private int id;

    private String asker;

    private String question;

    private QuestionType type;

    private int viewPoint;

    private boolean isHidden;

    private List<AnswerResponse> answers;

    private String createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public int getViewPoint() {
        return viewPoint;
    }

    public void setViewPoint(int viewPoint) {
        this.viewPoint = viewPoint;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public List<AnswerResponse> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerResponse> answers) {
        this.answers = answers;
    }

    public String getAsker() {
        return asker;
    }

    public void setAsker(String asker) {
        this.asker = asker;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
