package com.example.flipcardsapp.flipCard;

import com.example.flipcardsapp.mapper.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class FlipCardServiceTest {

    @Autowired
    FlipCardRepo flipCardRepo;
    @Autowired
    FlipCardService flipCardService;
    @Autowired
    Mapper mapper;

    @Test
    public void addFlipCard() {
        // given
        FlipCardImpDTO flipCardImpDTO = new FlipCardImpDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        FlipCardImpDTO flipCardImpDTO2 = new FlipCardImpDTO(new FlipCardFront("find"), new FlipCardBack("znaleźć"));

        // when
        flipCardService.addFlipCard(flipCardImpDTO);
        flipCardService.addFlipCard(flipCardImpDTO2);
        List<FlipCardImp> allNewCards = flipCardRepo.findAll();

        // then
        assertThat(allNewCards.size()).isEqualTo(2);

    }

    @Test
    public void removeFlipCard() {
        // given
        prepareFlipCards();

        // when
        flipCardService.removeFlipCard();

        // then

    }

    public void prepareFlipCards(){
        FlipCardImpDTO flipCardImpDTO = new FlipCardImpDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        FlipCardImpDTO flipCardImpDTO2 = new FlipCardImpDTO(new FlipCardFront("find"), new FlipCardBack("znaleźć"));
        flipCardService.addFlipCard(flipCardImpDTO);
        flipCardService.addFlipCard(flipCardImpDTO2);
    }


}