package com.example.flipcardsapp.userApp.dao.model;

import com.example.flipcardsapp.flipCard.dao.model.FlipCardImp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String emailAddress;
    private String password;
    @OneToMany()
    private List<FlipCardImp> flipCards = new ArrayList<>();

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
        this.flipCards.add(flipCard);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", flipCards=" + flipCards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id && Objects.equals(userName, appUser.userName) && Objects.equals(emailAddress, appUser.emailAddress) && Objects.equals(password, appUser.password) && Objects.equals(flipCards, appUser.flipCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, emailAddress, password, flipCards);
    }
}
