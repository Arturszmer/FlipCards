package com.example.flipcardsapp.flipCard.api;

import com.example.flipcardsapp.flipCard.dao.model.FlipCardBack;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardFront;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardImpDTO;
import com.example.flipcardsapp.flipCard.service.FlipCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/flipCards")
public class FlipCardController {

    private final FlipCardService flipCardService;

    public FlipCardController(FlipCardService flipCardService) {
        this.flipCardService = flipCardService;
    }

    @GetMapping
    public List<FlipCardImpDTO> allFlipCards (){
        return flipCardService.findAllFlipCards();
    }

    @GetMapping("/front")
    public List<FlipCardFront> showFrontFlipCards(){
        return flipCardService.showAllFrontFlipCards();
    }

    @GetMapping("/back")
    public List<FlipCardBack> showBackFlipCards(){
        return flipCardService.showAllBackFlipCards();
    }


}
