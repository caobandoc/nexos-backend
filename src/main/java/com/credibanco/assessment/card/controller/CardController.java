package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.dto.CardCreateDto;
import com.credibanco.assessment.card.dto.ResponseDto;
import com.credibanco.assessment.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(cardService.createCard(cardCreateDto));
    }
}
