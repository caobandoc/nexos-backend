package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.dto.*;
import com.credibanco.assessment.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<ResponseDto> createCard(@Valid @RequestBody CardCreateDto cardCreateDto) {
        return new ResponseEntity<>(cardService.createCard(cardCreateDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseDto> enroledCard(@Valid @RequestBody CardRequestDto cardRequestDto) {
        return ResponseEntity.ok(cardService.enroledCard(cardRequestDto));
    }

    @GetMapping("/{pan}")
    public ResponseEntity<ResponseCardDto> getCard(@PathVariable String pan) {
        return ResponseEntity.ok(cardService.getCard(pan));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteCard(@Valid @RequestBody CardRequestDto cardRequestDto) {
        return ResponseEntity.ok(cardService.deleteCard(cardRequestDto));
    }



}
