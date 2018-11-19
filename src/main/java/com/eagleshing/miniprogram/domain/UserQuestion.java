package com.eagleshing.miniprogram.domain;

import com.eagleshing.miniprogram.domain.audit.DateAudit;
import com.eagleshing.miniprogram.domain.type.QuestionType;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity(name = "user_question")
public class UserQuestion extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Lob
    private String question;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private QuestionType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
