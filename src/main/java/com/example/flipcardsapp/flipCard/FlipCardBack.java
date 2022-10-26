package com.example.flipcardsapp.flipCard;

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

    @Override
    public String toString() {
        return "FlipCardBack{" +
                "content='" + content + '\'' +
                '}';
    }
}