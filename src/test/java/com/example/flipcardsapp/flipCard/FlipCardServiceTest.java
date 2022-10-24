package com.example.flipcardsapp.flipCard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class FlipCardServiceTest {

    @Autowired
    FlipCardRepo flipCardRepo;

    @Test
    public void addFlipCard() {
        // given

        // when

        // then

    }

}