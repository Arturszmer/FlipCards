package com.example.flipcardsapp.mapper;

import com.example.flipcardsapp.flipCard.dao.model.FlipCardBack;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardFront;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardImp;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardImpDTO;
import com.example.flipcardsapp.userApp.dao.model.AppUser;
import com.example.flipcardsapp.userApp.dao.model.AppUserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

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
        UUID uuid = UUID.fromString(flipCardImp.getUuid());
        FlipCardFront flipCardFront = flipCardImp.getFlipCardFront();
        FlipCardBack flipCardBack = flipCardImp.getFlipCardBack();
        return new FlipCardImpDTO(studyPercent, uuid.toString(), flipCardFront, flipCardBack);
    }

    public FlipCardImp flipCardImpFromDTO (FlipCardImpDTO flipCardImpDTO){
        flipCardImpDTO.setUuid(UUID.randomUUID().toString());
        return new FlipCardImp(flipCardImpDTO.getStudyLevel(),
                UUID.fromString(flipCardImpDTO.getUuid()),
                flipCardImpDTO.getFlipCardFront(),
                flipCardImpDTO.getFlipCardBack());
    }
}
