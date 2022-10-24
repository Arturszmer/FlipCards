package com.example.flipcardsapp.flipCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlipCardRepo extends JpaRepository<FlipCardImp, Long> {

    Optional<FlipCardImp> findByFlipCardFront_Content(String content);
    Optional<FlipCardImp> deleteByFlipCardFront_Content(String content);
}