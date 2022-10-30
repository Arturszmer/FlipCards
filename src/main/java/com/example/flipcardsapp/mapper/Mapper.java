package com.example.flipcardsapp.mapper;

import com.example.flipcardsapp.flipCard.dao.model.FlipCard;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardDTO;
import com.example.flipcardsapp.userApp.dao.model.AppUser;
import com.example.flipcardsapp.userApp.dao.model.AppUserDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Mapper {

    public AppUserDTO appUserDTO(AppUser appUser){
        return new AppUserDTO(
                appUser.getUserName(),
                appUser.getEmailAddress(),
                appUser.getPassword(), appUser.getFlipCards()
                .stream()
                .map(this::flipCardDTO)
                .toList());
    }

    public AppUser appUserFromDTO (AppUserDTO appUserDTO){
        return new AppUser(
                appUserDTO.getUserName(),
                appUserDTO.getEmailAddres(),
                appUserDTO.getPassword(),
                appUserDTO.getFlipCards()
                        .stream()
                        .map(this::flipCardFromDTO)
                        .toList());
    }

    public FlipCardDTO flipCardDTO(FlipCard flipCard){
        return new FlipCardDTO(
                flipCard.getStudyPercent(),
                UUID.fromString(flipCard.getUuid()).toString(),
                flipCard.getFlipCardFront(), flipCard.getFlipCardBack());
    }

    public FlipCard flipCardFromDTO(FlipCardDTO flipCardDTO){
        flipCardDTO.setUuid(UUID.randomUUID().toString());
        return new FlipCard(
                flipCardDTO.getStudyLevel(),
                UUID.fromString(flipCardDTO.getUuid()),
                flipCardDTO.getFlipCardFront(),
                flipCardDTO.getFlipCardBack());
    }
}
