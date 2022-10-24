package com.example.flipcardsapp.userApp;

import com.example.flipcardsapp.flipCard.FlipCardRepo;
import com.example.flipcardsapp.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepo appUserRepo;
    private final FlipCardRepo flipCardRepo;
    private final Mapper mapper;

    public AppUserService(AppUserRepo appUserRepo, FlipCardRepo flipCardRepo, Mapper mapper) {
        this.appUserRepo = appUserRepo;
        this.flipCardRepo = flipCardRepo;
        this.mapper = mapper;
    }

    public List<AppUserDTO> getAllUsers() {
        return appUserRepo.findAll().stream()
                .map(mapper::appUserDTO)
                .toList();
    }
}
