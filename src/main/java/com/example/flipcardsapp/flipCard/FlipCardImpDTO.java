package com.example.flipcardsapp.flipCard;


public class FlipCardImpDTO {

    private final float studyLevel;
    private final FlipCardFront flipCardFront;
    private final FlipCardBack flipCardBack;

    public FlipCardImpDTO(float studyLevel, FlipCardFront flipCardFront, FlipCardBack flipCardBack) {
        this.studyLevel = studyLevel;
        this.flipCardFront = flipCardFront;
        this.flipCardBack = flipCardBack;
    }

    public float getStudyLevel() {
        return studyLevel;
    }

    public FlipCardFront getFlipCardFront() {
        return flipCardFront;
    }

    public FlipCardBack getFlipCardBack() {
        return flipCardBack;
    }
}
