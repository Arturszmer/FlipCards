package com.example.flipcardsapp.flipCard.dao.model;

import java.util.UUID;

public class FlipCardDTO {

    private float studyLevel;
    private String uuid;
    private FlipCardFront flipCardFront;
    private FlipCardBack flipCardBack;

    public FlipCardDTO() {
    }

    public FlipCardDTO(float studyLevel, String uuid, FlipCardFront flipCardFront, FlipCardBack flipCardBack) {
        this.studyLevel = studyLevel;
        this.uuid = uuid;
        this.flipCardFront = flipCardFront;
        this.flipCardBack = flipCardBack;
    }

    public FlipCardDTO(FlipCardFront flipCardFront, FlipCardBack flipCardBack) {
        this.flipCardFront = flipCardFront;
        this.flipCardBack = flipCardBack;
        this.studyLevel = 0.01f;
        this.uuid = UUID.randomUUID().toString();
    }

    public float getStudyLevel() {
        return studyLevel;
    }

    public String getUuid() {
        return uuid;
    }

    public FlipCardFront getFlipCardFront() {
        return flipCardFront;
    }

    public FlipCardBack getFlipCardBack() {
        return flipCardBack;
    }

    public void setStudyLevel(float studyLevel) {
        this.studyLevel = studyLevel;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
