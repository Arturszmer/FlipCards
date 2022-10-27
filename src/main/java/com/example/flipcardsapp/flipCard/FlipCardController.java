package com.example.flipcardsapp.flipCard;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class FlipCardController {

    private final FlipCardService flipCardService;

    public FlipCardController(FlipCardService flipCardService) {
        this.flipCardService = flipCardService;
    }

}
