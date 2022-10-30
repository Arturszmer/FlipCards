package com.example.flipcardsapp;

import com.example.flipcardsapp.flipCard.dao.model.FlipCardBack;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardFront;
import com.example.flipcardsapp.flipCard.dao.model.FlipCard;
import com.example.flipcardsapp.flipCard.dao.FlipCardRepo;
import com.example.flipcardsapp.userApp.dao.model.AppUser;
import com.example.flipcardsapp.userApp.dao.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("prod")
public class ProdDB implements CommandLineRunner {

    @Autowired
    FlipCardRepo flipCardRepo;
    @Autowired
    AppUserRepo appUserRepo;

    @Override
    public void run(String... args){
        FlipCard flipCard1 = new FlipCard(new FlipCardFront("river"), new FlipCardBack("rzeka"));
        FlipCard flipCard2 = new FlipCard(new FlipCardFront("wind"), new FlipCardBack("wiatro"));
        FlipCard flipCard3 = new FlipCard(new FlipCardFront("sea"), new FlipCardBack("morze"));
        FlipCard flipCard4 = new FlipCard(new FlipCardFront("attempt"), new FlipCardBack("próba"));
        FlipCard flipCard5 = new FlipCard(new FlipCardFront("inside"), new FlipCardBack("w środku"));
        FlipCard flipCard6 = new FlipCard(new FlipCardFront("labor law"), new FlipCardBack("prawo pracy"));
        flipCardRepo.save(flipCard1);
        flipCardRepo.save(flipCard2);
        flipCardRepo.save(flipCard3);
        flipCardRepo.save(flipCard4);
        flipCardRepo.save(flipCard5);
        flipCardRepo.save(flipCard6);
        List<FlipCard> allFLipCards = flipCardRepo.findAll();
        AppUser appUser1 = new AppUser("Artur", "artur@gmail.com", "xxyyz", allFLipCards);
        appUserRepo.save(appUser1);
    }

}
