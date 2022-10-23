package com.example.flipcardsapp.FlipCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlipCardRepo extends JpaRepository<FlipCardImp, Long> {

}
