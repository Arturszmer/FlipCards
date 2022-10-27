package com.example.flipcardsapp.flipCard;

import com.example.flipcardsapp.mapper.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlipCardService {

    private final FlipCardRepo flipCardRepo;
    private final Mapper mapper;

    public FlipCardService(FlipCardRepo flipCardRepo, Mapper mapper) {
        this.flipCardRepo = flipCardRepo;
        this.mapper = mapper;
    }

    public void addFlipCard(FlipCardImpDTO flipCardImpDTO) {
        flipCardRepo.save(mapper.flipCardImpFromDTO(flipCardImpDTO));
    }

    public void removeFlipCard() {
    }
}
