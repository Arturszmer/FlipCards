package com.example.flipcardsapp.flipCard;

import java.util.UUID;

public class FlipCardImpDTO {

    private final float studyLevel;
    private final String uuid;
    private final FlipCardFront flipCardFront;
    private final FlipCardBack flipCardBack;

    public FlipCardImpDTO(float studyLevel, UUID uuid, FlipCardFront flipCardFront, FlipCardBack flipCardBack) {
        this.studyLevel = studyLevel;
        this.uuid = uuid.toString();
        this.flipCardFront = flipCardFront;
        this.flipCardBack = flipCardBack;
    }

    public FlipCardImpDTO(FlipCardFront flipCardFront, FlipCardBack flipCardBack) {
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



}
