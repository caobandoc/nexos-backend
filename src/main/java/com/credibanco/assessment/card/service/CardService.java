package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.*;

public interface CardService {
    ResponseDto createCard(CardCreateDto cardCreateDto);

    ResponseDto enroledCard(CardRequestDto cardRequestDto);


    ResponseCardDto getCard(String pan);

    ResponseDto deleteCard(CardRequestDto cardRequestDto);

}
