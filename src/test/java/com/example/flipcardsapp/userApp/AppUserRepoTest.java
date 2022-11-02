package com.example.flipcardsapp.userApp;

import com.example.flipcardsapp.flipCard.dao.model.FlipCardBack;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardFront;
import com.example.flipcardsapp.flipCard.dao.model.FlipCard;
import com.example.flipcardsapp.flipCard.dao.FlipCardRepo;
import com.example.flipcardsapp.userApp.dao.model.AppUser;
import com.example.flipcardsapp.userApp.dao.AppUserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AppUserRepoTest {

    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    FlipCardRepo flipCardRepo;

    @Test
    public void addAppUser() {
        // given
        prepareData();
        // when
        List<AppUser> allAppUsers = appUserRepo.findAll();

        // then
        assertThat(allAppUsers.size()).isEqualTo(2);
    }

    @Test
    public void deleteAppUser() {
        // given
        prepareData();
        // when
        appUserRepo.deleteByUserName("RafałWin");
        List<AppUser> allCards = appUserRepo.findAll();
        // then
        assertThat(allCards.size()).isEqualTo(1);
    }

    @Test
    public void findSpecificUser() {
        // given
        prepareData();
        // when
        Optional<AppUser> rafalWinUser = appUserRepo.findByUserName("RafałWin");
        // then
        assertThat(rafalWinUser.get().getEmailAddress()).isEqualTo("Rafal@gmail.com");
    }

    @Test
    public void getFlipCardsFromUser() {
        // given
        prepareData();
        Optional<AppUser> arturSz88User = appUserRepo.findByUserName("ArturSz88");
        FlipCard flipCard = new FlipCard(new FlipCardFront("river"), new FlipCardBack("rzeka"));
        arturSz88User.get().assignFlipCard(flipCard);
        // when
        List<FlipCard> flipCardsFromUser = arturSz88User.get().getFlipCards();
        // then
        assertThat(flipCardsFromUser.get(0).getFlipCardFront().getContent()).isEqualTo("river");

    }

    private void prepareData() {
        AppUser appUser1 = new AppUser("ArturSz88", "artur@gmail.com", "haslo", new ArrayList<>());
        AppUser appUser2 = new AppUser("RafałWin", "Rafal@gmail.com", "pass", new ArrayList<>());
        appUserRepo.save(appUser1);
        appUserRepo.save(appUser2);
    }

}