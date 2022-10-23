package com.example.flipcardsapp.FlipCard;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlipCardService {

    public FlipCardService(FlipCardRepo flipCardRepo) {
    }


}
