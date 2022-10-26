package com.example.flipcardsapp.flipCard;

public class FlipCardImpDTO {

    private final float studyLevel;
    private final FlipCardFront flipCardFront;
    private final FlipCardBack flipCardBack;
    private final StudyLevel level;

    public FlipCardImpDTO(float studyLevel, FlipCardFront flipCardFront, FlipCardBack flipCardBack, StudyLevel level) {
        this.studyLevel = studyLevel;
        this.flipCardFront = flipCardFront;
        this.flipCardBack = flipCardBack;
        this.level = level;
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

    public StudyLevel getLevel() {
        return level;
    }
}
