package com.example.flipcardsapp.flipCard.dao;

import com.example.flipcardsapp.flipCard.dao.model.FlipCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlipCardRepo extends JpaRepository<FlipCard, Long> {

    Optional<FlipCard> findByFlipCardFrontContent(String content);
    Optional<FlipCard> deleteByFlipCardFrontContent(String content);
    Optional<FlipCard> deleteByUuid(String uuid);
    Optional<FlipCard> findFlipCardImpByUuid(String uuid);
}
