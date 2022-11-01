package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.CardCreateDto;
import com.credibanco.assessment.card.dto.CardRequestDto;
import com.credibanco.assessment.card.dto.ResponseCardDto;
import com.credibanco.assessment.card.dto.ResponseDto;

public interface CardService {
    ResponseDto createCard(CardCreateDto cardCreateDto);

    ResponseDto enroledCard(CardRequestDto cardRequestDto);


    ResponseCardDto getCard(String pan);

    ResponseDto deleteCard(CardRequestDto cardRequestDto);
}
