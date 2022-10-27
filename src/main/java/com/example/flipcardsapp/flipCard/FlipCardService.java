package com.example.flipcardsapp.flipCard;

import com.example.flipcardsapp.exceptionHandler.MyExceptions;
import com.example.flipcardsapp.mapper.Mapper;
import org.springframework.http.HttpStatus;
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

    public void deleteFlipCard(FlipCardImpDTO flipCardImpDTO) {
        flipCardRepo.deleteByUuid(flipCardImpDTO.getUuid());
    }

    public FlipCardImp editFlipCardFrontContent(FlipCardImpDTO flipCardImpDTO, String content) {
        FlipCardImp flipCardImp = flipCardRepo.findFlipCardImpByUuid(flipCardImpDTO.getUuid())
                .orElseThrow(() -> new MyExceptions(HttpStatus.NOT_FOUND, "This flip card doesn't exist"));
        flipCardImp.getFlipCardFront().setContent(content);
        return flipCardImp;
    }

    public FlipCardImp editFlipCardBackContent(FlipCardImpDTO flipCardImpDTO, String content) {
        FlipCardImp flipCardImp = flipCardRepo.findFlipCardImpByUuid(flipCardImpDTO.getUuid())
                .orElseThrow(() -> new MyExceptions(HttpStatus.NOT_FOUND, " This flip card doesn't exist"));
        flipCardImp.getFlipCardBack().setContent(content);
        return flipCardImp;
    }
}
