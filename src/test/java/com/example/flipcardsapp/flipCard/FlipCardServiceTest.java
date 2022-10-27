package com.example.flipcardsapp.flipCard;

import com.example.flipcardsapp.flipCard.dao.*;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardBack;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardFront;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardImp;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardImpDTO;
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
        FlipCardImpDTO flipCardImpDTO = new FlipCardImpDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        FlipCardImpDTO flipCardImpDTO2 = new FlipCardImpDTO(new FlipCardFront("find"), new FlipCardBack("znaleźć"));

        // when
        flipCardService.addFlipCard(flipCardImpDTO);
        flipCardService.addFlipCard(flipCardImpDTO2);
        List<FlipCardImp> allNewFlipCards = flipCardRepo.findAll();

        // then
        assertThat(allNewFlipCards.size()).isEqualTo(2);
    }

    @Test
    public void removeFlipCard() {
        // given
        FlipCardImpDTO flipCardImpDTO = new FlipCardImpDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        flipCardService.addFlipCard(flipCardImpDTO);

        // when
        flipCardService.deleteFlipCard(flipCardImpDTO);
        List<FlipCardImp> allFlipCards = flipCardRepo.findAll();

        // then
        assertThat(allFlipCards.size()).isEqualTo(0);
    }

    @Test
    public void editFLipCardFrontContent() {
        // given
        FlipCardImpDTO flipCardImpDTO = new FlipCardImpDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        flipCardService.addFlipCard(flipCardImpDTO);

        // when
        flipCardService.editFlipCardFrontContent(flipCardImpDTO, "road, way");
        Optional<FlipCardImp> changedFlipCard = flipCardRepo.findFlipCardImpByUuid(flipCardImpDTO.getUuid());
        // then
        assertThat(changedFlipCard.get().getFlipCardFront().getContent()).isEqualTo("road, way");
    }

    @Test
    public void editFlipCardBackContent() {
        // given
        FlipCardImpDTO flipCardImpDTO = new FlipCardImpDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        flipCardService.addFlipCard(flipCardImpDTO);

        // when
        flipCardService.editFlipCardBackContent(flipCardImpDTO, "droga, szosa, trakt");
        Optional<FlipCardImp> changedFlipCard = flipCardRepo.findFlipCardImpByUuid(flipCardImpDTO.getUuid());
        // then
        assertThat(changedFlipCard.get().getFlipCardBack().getContent()).isEqualTo("droga, szosa, trakt");
    }

    @Test
    public void allFlipCards() {
        // given
        prepareFlipCards();

        // when
        List<FlipCardImpDTO> allFlipCards = flipCardService.findAllFlipCards();

        // then
        assertThat(allFlipCards.size()).isEqualTo(2);
    }

    @Test
    public void allFrontFLipCards() {
        // given
        prepareFlipCards();

        // when
        List<FlipCardFront> flipCardFronts = flipCardService.showAllFrontFlipCards();

        // then
        assertThat(flipCardFronts.get(0).getContent()).isEqualTo("road");

    }

    @Test
    public void allBackFlipCards() {
        // given
        prepareFlipCards();

        // when
        List<FlipCardBack> flipCardBacks = flipCardService.showAllBackFlipCards();

        // then
        assertThat(flipCardBacks.get(0).getContent()).isEqualTo("droga");
    }

    public void prepareFlipCards(){
        FlipCardImpDTO flipCardImpDTO = new FlipCardImpDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        FlipCardImpDTO flipCardImpDTO2 = new FlipCardImpDTO(new FlipCardFront("find"), new FlipCardBack("znaleźć"));
        flipCardService.addFlipCard(flipCardImpDTO);
        flipCardService.addFlipCard(flipCardImpDTO2);
    }
}