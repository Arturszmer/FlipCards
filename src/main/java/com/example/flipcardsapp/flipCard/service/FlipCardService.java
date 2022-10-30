package com.example.flipcardsapp.flipCard.service;

import com.example.flipcardsapp.exceptionHandler.MyExceptions;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardBack;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardFront;
import com.example.flipcardsapp.flipCard.dao.model.FlipCard;
import com.example.flipcardsapp.flipCard.dao.model.FlipCardDTO;
import com.example.flipcardsapp.flipCard.dao.FlipCardRepo;
import com.example.flipcardsapp.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlipCardService {

    private final FlipCardRepo flipCardRepo;
    private final Mapper mapper;

    public FlipCardService(FlipCardRepo flipCardRepo, Mapper mapper) {
        this.flipCardRepo = flipCardRepo;
        this.mapper = mapper;
    }

    @Transactional
    public void createFlipCard(FlipCardDTO flipCardDTO) {
        flipCardRepo.save(mapper.flipCardFromDTO(flipCardDTO));
    }

    @Transactional
    public void deleteFlipCard(FlipCardDTO flipCardDTO) {
        flipCardRepo.deleteByUuid(flipCardDTO.getUuid());
    }

    @Transactional
    public FlipCard editFlipCardFrontContent(FlipCardDTO flipCardDTO, String content) {
        FlipCard flipCard = flipCardRepo.findFlipCardImpByUuid(flipCardDTO.getUuid())
                .orElseThrow(() -> new MyExceptions(HttpStatus.NOT_FOUND, "This flip card doesn't exist"));
        flipCard.getFlipCardFront().setContent(content);
        return flipCard;
    }

    @Transactional
    public FlipCard editFlipCardBackContent(FlipCardDTO flipCardDTO, String content) {
        FlipCard flipCard = flipCardRepo.findFlipCardImpByUuid(flipCardDTO.getUuid())
                .orElseThrow(() -> new MyExceptions(HttpStatus.NOT_FOUND, " This flip card doesn't exist"));
        flipCard.getFlipCardBack().setContent(content);
        return flipCard;
    }

    @Transactional(readOnly = true )
    public List<FlipCardDTO> findAllFlipCards() {
        return flipCardRepo.findAll().stream()
                .map(mapper::flipCardDTO)
                .toList();
    }

    @Transactional(readOnly = true )
    public List<FlipCardFront> findAllFrontFlipCards() {
        return flipCardRepo.findAll().stream()
                .map(FlipCard::getFlipCardFront)
                .toList();
    }

    @Transactional(readOnly = true )
    public List<FlipCardBack> findAllBackFlipCards() {
        return flipCardRepo.findAll().stream()
                .map(FlipCard::getFlipCardBack)
                .toList();
    }
}
