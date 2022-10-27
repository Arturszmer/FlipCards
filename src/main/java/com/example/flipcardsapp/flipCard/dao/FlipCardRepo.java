package com.example.flipcardsapp.flipCard.dao;

import com.example.flipcardsapp.flipCard.dao.model.FlipCardImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlipCardRepo extends JpaRepository<FlipCardImp, Long> {

    Optional<FlipCardImp> findByFlipCardFront_Content(String content);
    Optional<FlipCardImp> deleteByFlipCardFront_Content(String content);
    Optional<FlipCardImp> deleteByUuid(String uuid);
    Optional<FlipCardImp> findFlipCardImpByUuid(String uuid);
}
