package com.example.flipcardsapp.flipCard;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class FlipCardImp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float studyPercent;
    private String uuid;

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
        this.uuid = UUID.randomUUID().toString();
    }

    public FlipCardImp(float studyPercent, UUID uuid, FlipCardFront flipCardFront, FlipCardBack flipCardBack) {
        this.studyPercent = studyPercent;
        this.uuid = uuid.toString();
        this.flipCardFront = flipCardFront;
        this.flipCardBack = flipCardBack;
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

    public String getUuid() {
        return uuid;
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
                ", uuid=" + uuid +
                ", flipCardFront=" + flipCardFront +
                ", flipCardBack=" + flipCardBack +
                '}';
    }
}
