package com.example.flipcardsapp.userApp;

import com.example.flipcardsapp.flipCard.FlipCardService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class AppUserController {

    public AppUserController(AppUserService appUserService, FlipCardService flipCardService) {
    }

    @GetMapping
    List<AppUserDTO> users (){
        return null;
    }

}
