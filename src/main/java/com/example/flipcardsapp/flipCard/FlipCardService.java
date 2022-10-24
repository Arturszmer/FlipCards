package com.example.flipcardsapp.flipCard;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlipCardService {

    public FlipCardService(FlipCardRepo flipCardRepo) {
    }


}
