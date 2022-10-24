package com.example.flipcardsapp.flipCard;

import javax.persistence.*;

@Entity
public class FlipCardBack implements FlipCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;
    private StudyLevel level;

    public FlipCardBack() {
    }

    public FlipCardBack(String content) {
        this.content = content;
        this.level = StudyLevel.BAD;
    }

    public String getContent() {
        return content;
    }

    public StudyLevel getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "FlipCardBack{" +
                "content='" + content + '\'' +
                ", level=" + level +
                '}';
    }
}