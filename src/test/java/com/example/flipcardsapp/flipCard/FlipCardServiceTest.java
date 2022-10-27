package com.example.flipcardsapp.flipCard;

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

    public void prepareFlipCards(){
        FlipCardImpDTO flipCardImpDTO = new FlipCardImpDTO(new FlipCardFront("road"), new FlipCardBack("droga"));
        FlipCardImpDTO flipCardImpDTO2 = new FlipCardImpDTO(new FlipCardFront("find"), new FlipCardBack("znaleźć"));
        flipCardService.addFlipCard(flipCardImpDTO);
        flipCardService.addFlipCard(flipCardImpDTO2);
    }


}