package com.example.flipcardsapp.flipCard.dao.model;

import javax.persistence.*;

@Entity
public class FlipCardFront {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    public FlipCardFront(String content) {
        this.content = content;
    }

    public FlipCardFront() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "FlipCardFront{" +
                "content='" + content + '\'' +
                '}';
    }
}
