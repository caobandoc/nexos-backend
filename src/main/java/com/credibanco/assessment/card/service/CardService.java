package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.CardCreateDto;
import com.credibanco.assessment.card.dto.CardEnroledDto;
import com.credibanco.assessment.card.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface CardService {
    ResponseDto createCard(CardCreateDto cardCreateDto);

    ResponseDto enroledCard(CardEnroledDto cardEnroledDto);


}
