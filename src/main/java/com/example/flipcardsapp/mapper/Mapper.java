package com.example.flipcardsapp.mapper;

import com.example.flipcardsapp.flipCard.*;
import com.example.flipcardsapp.userApp.AppUser;
import com.example.flipcardsapp.userApp.AppUserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public AppUserDTO appUserDTO(AppUser appUser){
        String userName = appUser.getUserName();
        String emailAddress = appUser.getEmailAddress();
        String password = appUser.getPassword();
        List<FlipCardImpDTO> flipCard = appUser.getFlipCards()
                .stream()
                .map(this::flipCardImpDTO)
                .toList();
        return new AppUserDTO(userName, emailAddress, password, flipCard);
    }

    public AppUser appUserFromDTO (AppUserDTO appUserDTO){
        return new AppUser(appUserDTO.getUserName(),
                appUserDTO.getEmailAddres(),
                appUserDTO.getPassword(),
                appUserDTO.getFlipCards()
                        .stream()
                        .map(this::flipCardImpFromDTO)
                        .toList());
    }

    public FlipCardImpDTO flipCardImpDTO (FlipCardImp flipCardImp){
        float studyPercent = flipCardImp.getStudyPercent();
        FlipCardFront flipCardFront = flipCardImp.getFlipCardFront();
        FlipCardBack flipCardBack = flipCardImp.getFlipCardBack();
        return new FlipCardImpDTO(studyPercent, flipCardFront, flipCardBack);
    }

    public FlipCardImp flipCardImpFromDTO (FlipCardImpDTO flipCardImpDTO){
        return new FlipCardImp(flipCardImpDTO.getFlipCardFront(), flipCardImpDTO.getFlipCardBack());
    }
}
