package com.example.flipcardsapp.flipCard;

import com.example.flipcardsapp.flipCard.dao.model.FlipCardBack;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardFront;
import com.example.flipcardsapp.flipCard.dao.model.FlipCard;
import com.example.flipcardsapp.flipCard.dao.FlipCardRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class FlipCardRepoTest {

    @Autowired
    FlipCardRepo flipCardRepo;

    @Test
    public void addFlipCard(){
        // given
        FlipCard flipCard = getFlipCardOne();
        // when
        flipCardRepo.save(flipCard);
        List<FlipCard> allCards = flipCardRepo.findAll();
        // then
        assertThat(allCards.size()).isEqualTo(1);
    }

    @Test
    public void deleteSpecificFlipCard() {
        // given
        FlipCard flipCard1 = getFlipCardOne();
        FlipCard flipCard2 = getFlipCardTwo();
        flipCardRepo.save(flipCard1);
        flipCardRepo.save(flipCard2);
        // when
        flipCardRepo.deleteByFlipCardFrontContent("river");
        List<FlipCard> allFlipCards = flipCardRepo.findAll();
        // then
        assertThat(allFlipCards.size()).isEqualTo(1);
    }

    @Test
    public void findSpecificFlipCard() {
        // given
        FlipCard flipCard1 = getFlipCardOne();
        flipCardRepo.save(flipCard1);

        // when
        Optional<FlipCard> riverCard = flipCardRepo.findByFlipCardFrontContent("river");

        // then
        assertThat(riverCard.get()).isEqualTo(flipCard1);
    }

    @Test
    public void findFlipCardByUUID() {
        // given
        FlipCard flipCard1 = getFlipCardOne();
        flipCardRepo.save(flipCard1);

        // when
        Optional<FlipCard> byUuid = flipCardRepo.findFlipCardImpByUuid(flipCard1.getUuid());

        // then
        assertThat(byUuid.get()).isEqualTo(flipCard1);
    }

    @Test
    public void checkCardLevelStudy() {
        // given
        FlipCard flipCard1 = getFlipCardOne();
        FlipCard flipCard2 = getFlipCardTwo();
        flipCardRepo.save(flipCard1);
        flipCardRepo.save(flipCard2);

        // when
        Optional<FlipCard> riverCard = flipCardRepo.findByFlipCardFrontContent("river");
        Optional<Float> percentOfStudy = riverCard.stream().map(FlipCard::getStudyPercent).findFirst();

        // then
        assertThat(percentOfStudy.get()).isEqualTo(0.01f);

    }

    private static FlipCard getFlipCardOne() {
        return new FlipCard(new FlipCardFront("river"), new FlipCardBack("rzeka"));
    }

    private static FlipCard getFlipCardTwo() {
        return new FlipCard(new FlipCardFront("wind"), new FlipCardBack("wiatr"));
    }
}