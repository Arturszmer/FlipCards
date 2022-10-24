package com.example.flipcardsapp.flipCard;

import javax.persistence.*;

@Entity
public class FlipCardFront implements FlipCard{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private StudyLevel level;

    public FlipCardFront(String content) {
        this.content = content;
        this.level = StudyLevel.BAD;
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
                ", level=" + level +
                '}';
    }
}
