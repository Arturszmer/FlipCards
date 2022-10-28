package com.example.flipcardsapp.flipCard;

import com.example.flipcardsapp.flipCard.dao.model.FlipCardBack;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardFront;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardImp;
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
        FlipCardImp flipCardImp = getFlipCardImpOne();
        // when
        flipCardRepo.save(flipCardImp);
        List<FlipCardImp> allCards = flipCardRepo.findAll();
        // then
        assertThat(allCards.size()).isEqualTo(1);
    }

    @Test
    public void deleteSpecificFlipCard() {
        // given
        FlipCardImp flipCardImp1 = getFlipCardImpOne();
        FlipCardImp flipCardImp2 = getFlipCardImpTwo();
        flipCardRepo.save(flipCardImp1);
        flipCardRepo.save(flipCardImp2);
        // when
        System.out.println(flipCardRepo.findAll() + "wffw");
        flipCardRepo.deleteByFlipCardFront_Content("river");
        List<FlipCardImp> allFlipCards = flipCardRepo.findAll();
        System.out.println(allFlipCards + "aabb");
        // then
        assertThat(allFlipCards.size()).isEqualTo(1);
    }

    @Test
    public void findSpecificFlipCard() {
        // given
        FlipCardImp flipCardImp1 = getFlipCardImpOne();
        flipCardRepo.save(flipCardImp1);

        // when
        Optional<FlipCardImp> riverCard = flipCardRepo.findByFlipCardFront_Content("river");

        // then
        assertThat(riverCard.get()).isEqualTo(flipCardImp1);
    }

    @Test
    public void findFlipCardByUUID() {
        // given
        FlipCardImp flipCardImp1 = getFlipCardImpOne();
        flipCardRepo.save(flipCardImp1);

        // when
        Optional<FlipCardImp> byUuid = flipCardRepo.findFlipCardImpByUuid(flipCardImp1.getUuid());

        // then
        assertThat(byUuid.get()).isEqualTo(flipCardImp1);
    }

    @Test
    public void checkCardLevelStudy() {
        // given
        FlipCardImp flipCardImp1 = getFlipCardImpOne();
        FlipCardImp flipCardImp2 = getFlipCardImpTwo();
        flipCardRepo.save(flipCardImp1);
        flipCardRepo.save(flipCardImp2);

        // when
        Optional<FlipCardImp> riverCard = flipCardRepo.findByFlipCardFront_Content("river");
        Optional<Float> percentOfStudy = riverCard.stream().map(FlipCardImp::getStudyPercent).findFirst();

        // then
        assertThat(percentOfStudy.get()).isEqualTo(0.01f);

    }

    private static FlipCardImp getFlipCardImpOne() {
        FlipCardFront flipCardFront = new FlipCardFront("river");
        FlipCardBack flipCardBack = new FlipCardBack("rzeka");
        return new FlipCardImp(flipCardFront, flipCardBack);
    }

    private static FlipCardImp getFlipCardImpTwo() {
        FlipCardFront flipCardFront = new FlipCardFront("wind");
        FlipCardBack flipCardBack = new FlipCardBack("wiatr");
        return new FlipCardImp(flipCardFront, flipCardBack);
    }
}