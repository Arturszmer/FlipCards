package com.example.flipcardsapp.flipCard;

import com.example.flipcardsapp.flipCard.dao.*;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardBack;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardFront;
import com.example.flipcardsapp.flipCard.dao.model.FlipCard;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardDTO;
import com.example.flipcardsapp.flipCard.service.FlipCardService;
import com.example.flipcardsapp.mapper.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        FlipCardDTO flipCardDTO = new FlipCardDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        FlipCardDTO flipCardDTO2 = new FlipCardDTO(new FlipCardFront("find"), new FlipCardBack("znaleźć"));

        // when
        flipCardService.createFlipCard(flipCardDTO);
        flipCardService.createFlipCard(flipCardDTO2);
        List<FlipCard> allNewFlipCards = flipCardRepo.findAll();

        // then
        assertThat(allNewFlipCards.size()).isEqualTo(2);
    }

    @Test
    public void removeFlipCard() {
        // given
        FlipCardDTO flipCardDTO = new FlipCardDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        flipCardService.createFlipCard(flipCardDTO);

        // when
        flipCardService.deleteFlipCard(flipCardDTO);
        List<FlipCard> allFlipCards = flipCardRepo.findAll();

        // then
        assertThat(allFlipCards.size()).isEqualTo(0);
    }

    @Test
    public void editFLipCardFrontContent() {
        // given
        FlipCardDTO flipCardDTO = new FlipCardDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        flipCardService.createFlipCard(flipCardDTO);

        // when
        flipCardService.editFlipCardFrontContent(flipCardDTO, "road, way");
        Optional<FlipCard> changedFlipCard = flipCardRepo.findFlipCardImpByUuid(flipCardDTO.getUuid());
        // then
        assertThat(changedFlipCard.get().getFlipCardFront().getContent()).isEqualTo("road, way");
    }

    @Test
    public void editFlipCardBackContent() {
        // given
        FlipCardDTO flipCardDTO = new FlipCardDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        flipCardService.createFlipCard(flipCardDTO);

        // when
        flipCardService.editFlipCardBackContent(flipCardDTO, "droga, szosa, trakt");
        Optional<FlipCard> changedFlipCard = flipCardRepo.findFlipCardImpByUuid(flipCardDTO.getUuid());
        // then
        assertThat(changedFlipCard.get().getFlipCardBack().getContent()).isEqualTo("droga, szosa, trakt");
    }

    @Test
    public void allFlipCards() {
        // given
        prepareFlipCards();

        // when
        List<FlipCardDTO> allFlipCards = flipCardService.findAllFlipCards();

        // then
        assertThat(allFlipCards.size()).isEqualTo(2);
    }

    @Test
    public void allFrontFLipCards() {
        // given
        prepareFlipCards();

        // when
        List<FlipCardFront> flipCardFronts = flipCardService.findAllFrontFlipCards();

        // then
        assertThat(flipCardFronts.get(0).getContent()).isEqualTo("road");

    }

    @Test
    public void allBackFlipCards() {
        // given
        prepareFlipCards();

        // when
        List<FlipCardBack> flipCardBacks = flipCardService.findAllBackFlipCards();

        // then
        assertThat(flipCardBacks.get(0).getContent()).isEqualTo("droga");
    }

    public void prepareFlipCards(){
        FlipCardDTO flipCardDTO = new FlipCardDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        FlipCardDTO flipCardDTO2 = new FlipCardDTO(new FlipCardFront("find"), new FlipCardBack("znaleźć"));
        flipCardService.createFlipCard(flipCardDTO);
        flipCardService.createFlipCard(flipCardDTO2);
    }
}