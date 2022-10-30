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
        FlipCard flipCardRiver = getFlipCardRiver();
        // when
        flipCardRepo.save(flipCardRiver);
        List<FlipCard> allCards = flipCardRepo.findAll();
        // then
        assertThat(allCards.size()).isEqualTo(1);
    }

    @Test
    public void deleteSpecificFlipCard() {
        // given
        FlipCard flipCardRiver = getFlipCardRiver();
        FlipCard flipCardWind = getFlipCardWind();
        flipCardRepo.save(flipCardWind);
        flipCardRepo.save(flipCardWind);
        // when
        flipCardRepo.deleteByFlipCardFrontContent("river");
        List<FlipCard> allFlipCards = flipCardRepo.findAll();
        // then
        assertThat(allFlipCards.size()).isEqualTo(1);
    }

    @Test
    public void findSpecificFlipCard() {
        // given
        FlipCard flipCardRiver = getFlipCardRiver();
        flipCardRepo.save(flipCardRiver);

        // when
        Optional<FlipCard> riverCard = flipCardRepo.findByFlipCardFrontContent("river");

        // then
        assertThat(riverCard.get()).isEqualTo(flipCardRiver);
    }

    @Test
    public void findFlipCardByUUID() {
        // given
        FlipCard flipCardRiver = getFlipCardRiver();
        flipCardRepo.save(flipCardRiver);

        // when
        Optional<FlipCard> byUuid = flipCardRepo.findFlipCardImpByUuid(flipCardRiver.getUuid());

        // then
        assertThat(byUuid.get()).isEqualTo(flipCardRiver);
    }

    @Test
    public void checkCardLevelStudy() {
        // given
        FlipCard flipCardRiver = getFlipCardRiver();
        FlipCard flipCardWind = getFlipCardWind();
        flipCardRepo.save(flipCardRiver);
        flipCardRepo.save(flipCardWind);

        // when
        Optional<FlipCard> riverCard = flipCardRepo.findByFlipCardFrontContent("river");
        Optional<Float> percentOfStudy = riverCard.stream().map(FlipCard::getStudyPercent).findFirst();

        // then
        assertThat(percentOfStudy.get()).isEqualTo(0.01f);

    }

    private static FlipCard getFlipCardRiver() {
        return new FlipCard(
                new FlipCardFront("river"), new FlipCardBack("rzeka"));
    }

    private static FlipCard getFlipCardWind() {
        return new FlipCard(new FlipCardFront("wind"), new FlipCardBack("wiatr"));
    }
}