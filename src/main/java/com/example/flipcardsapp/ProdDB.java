package com.example.flipcardsapp;

import com.example.flipcardsapp.flipCard.FlipCardBack;
import com.example.flipcardsapp.flipCard.FlipCardFront;
import com.example.flipcardsapp.flipCard.FlipCardImp;
import com.example.flipcardsapp.flipCard.FlipCardRepo;
import com.example.flipcardsapp.userApp.AppUser;
import com.example.flipcardsapp.userApp.AppUserRepo;
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
        FlipCardImp flipCardImp1 = new FlipCardImp(new FlipCardFront("river"), new FlipCardBack("rzeka"));
        FlipCardImp flipCardImp2 = new FlipCardImp(new FlipCardFront("wind"), new FlipCardBack("wiatro"));
        flipCardRepo.save(flipCardImp1);
        flipCardRepo.save(flipCardImp2);
        List<FlipCardImp> allFLipCards = flipCardRepo.findAll();
        AppUser appUser1 = new AppUser("Artur", "artur@gmail.com", "xxyyz", allFLipCards);
        appUserRepo.save(appUser1);
    }

}
