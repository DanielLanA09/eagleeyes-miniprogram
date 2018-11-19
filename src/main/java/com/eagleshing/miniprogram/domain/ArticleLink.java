package com.eagleshing.miniprogram.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "article_link")
public class ArticleLink {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private int view;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
