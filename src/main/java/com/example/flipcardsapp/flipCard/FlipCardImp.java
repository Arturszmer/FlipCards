package com.example.flipcardsapp.flipCard;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class FlipCardImp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float studyPercent;

    @OneToOne(cascade = CascadeType.ALL)

    private FlipCardFront flipCardFront;
    @OneToOne(cascade = CascadeType.ALL)
    private FlipCardBack flipCardBack;

    public FlipCardImp() {
    }

    public FlipCardImp(FlipCardFront flipCardFront, FlipCardBack flipCardBack) {
        this.flipCardFront = flipCardFront;
        this.flipCardBack = flipCardBack;
        this.studyPercent = 0.01f;
    }

    public FlipCardFront getFlipCardFront() {
        return flipCardFront;
    }

    public FlipCardBack getFlipCardBack() {
        return flipCardBack;
    }

    public float getStudyPercent() {
        return studyPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlipCardImp that = (FlipCardImp) o;
        return id == that.id && Objects.equals(flipCardFront, that.flipCardFront) && Objects.equals(flipCardBack, that.flipCardBack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flipCardFront, flipCardBack);
    }

    @Override
    public String toString() {
        return "FlipCardImp{" +
                "studyPercent=" + studyPercent +
                ", flipCardFront=" + flipCardFront +
                ", flipCardBack=" + flipCardBack +
                '}';
    }
}
