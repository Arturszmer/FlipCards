package com.example.flipcardsapp.userApp;

import com.example.flipcardsapp.flipCard.FlipCardRepo;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    public AppUserService(AppUserRepo appUserRepo, FlipCardRepo flipCardRepo) {
    }

}
