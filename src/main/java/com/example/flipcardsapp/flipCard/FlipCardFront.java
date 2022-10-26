package com.example.flipcardsapp.flipCard;

import javax.persistence.*;

@Entity
public class FlipCardFront implements FlipCard{

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

    @Override
    public String toString() {
        return "FlipCardFront{" +
                "content='" + content + '\'' +
                '}';
    }
}
