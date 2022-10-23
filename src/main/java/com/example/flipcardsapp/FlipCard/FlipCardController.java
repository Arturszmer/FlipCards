package com.example.flipcardsapp.FlipCard;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class FlipCardController {

    public FlipCardController(FlipCardService flipCardService) {
    }

}
