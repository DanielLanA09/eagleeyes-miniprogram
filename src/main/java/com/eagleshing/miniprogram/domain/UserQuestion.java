package com.eagleshing.miniprogram.domain;

import com.eagleshing.miniprogram.domain.audit.DateAudit;
import com.eagleshing.miniprogram.domain.type.QuestionType;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "user_question")
public class UserQuestion extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    @NotNull
    private Integer userId;

    @Lob
    private String question;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private QuestionType type;

    @Column(name = "view_point")
    private int viewPoint;

    @Column(name = "is_hidden")
    private boolean isHidden;

    @Column(length = 11, name = "phone_number")
    private String phoneNumber;
    

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public int getViewPoint() {
        return viewPoint;
    }

    public void setViewPoint(int viewPoint) {
        this.viewPoint = viewPoint;
    }

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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
