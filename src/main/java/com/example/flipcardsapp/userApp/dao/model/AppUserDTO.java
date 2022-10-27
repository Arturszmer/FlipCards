package com.example.flipcardsapp.userApp.dao.model;

import com.example.flipcardsapp.flipCard.dao.model.FlipCardImpDTO;

import java.util.Collections;
import java.util.List;

public class AppUserDTO {

    private final String userName;
    private final String emailAddres;
    private final String password;
    private final List<FlipCardImpDTO> flipCards;

    public AppUserDTO(String userName, String emailAddres, String password, List<FlipCardImpDTO> flipCards) {
        this.userName = userName;
        this.emailAddres = emailAddres;
        this.password = password;
        this.flipCards = flipCards;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddres() {
        return emailAddres;
    }

    public String getPassword() {
        return password;
    }

    public List<FlipCardImpDTO> getFlipCards() {
        return Collections.unmodifiableList(flipCards);
    }

    public void assignFlipCard(FlipCardImpDTO flipCardImpDTO){
        flipCards.add(flipCardImpDTO);
    }
}
