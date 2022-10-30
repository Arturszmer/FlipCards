package com.example.flipcardsapp.flipCard.controller;

import com.example.flipcardsapp.flipCard.dao.model.FlipCardBack;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardFront;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardDTO;
import com.example.flipcardsapp.flipCard.service.FlipCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<FlipCardDTO> allFlipCards (){
        return flipCardService.findAllFlipCards();
    }

    @GetMapping("/front")
    public List<FlipCardFront> showFrontFlipCards(){
        return flipCardService.findAllFrontFlipCards();
    }

    @GetMapping("/back")
    public List<FlipCardBack> showBackFlipCards(){
        return flipCardService.findAllBackFlipCards();
    }

    @PostMapping
    public ResponseEntity<Void> createFlipCard(@RequestBody FlipCardDTO flipCardDTO){
        flipCardService.createFlipCard(flipCardDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}