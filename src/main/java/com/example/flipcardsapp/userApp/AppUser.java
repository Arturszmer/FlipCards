package com.example.flipcardsapp.userApp;

import com.example.flipcardsapp.flipCard.FlipCardImp;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String emailAddress;
    private String password;
    @OneToMany()
    private List<FlipCardImp> flipCards;

    public AppUser() {
    }

    public AppUser(String userName, String emailAddress, String password, List<FlipCardImp> flipCards) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.flipCards = flipCards;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public List<FlipCardImp> getFlipCards() {
        return Collections.unmodifiableList(flipCards);
    }

    public void assignFlipCard(FlipCardImp flipCard){
        flipCards.add(flipCard);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", flipCards=" + flipCards +
                '}';
    }
}
