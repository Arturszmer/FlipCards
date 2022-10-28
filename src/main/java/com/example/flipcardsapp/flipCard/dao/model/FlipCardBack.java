package com.example.flipcardsapp.flipCard.dao.model;

import javax.persistence.*;

@Entity
public class FlipCardBack implements FlipCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;

    public FlipCardBack() {
    }

    public FlipCardBack(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "FlipCardBack{" +
                "content='" + content + '\'' +
                '}';
    }
}