package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.constants.MessageResponse;
import com.credibanco.assessment.card.constants.StateCard;
import com.credibanco.assessment.card.dto.CardCreateDto;
import com.credibanco.assessment.card.dto.CardRequestDto;
import com.credibanco.assessment.card.dto.ResponseCardDto;
import com.credibanco.assessment.card.dto.ResponseDto;
import com.credibanco.assessment.card.exceptions.CardFoundException;
import com.credibanco.assessment.card.exceptions.CardNotFoundException;
import com.credibanco.assessment.card.exceptions.InvalidCVVException;
import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.repository.CardRepository;
import com.credibanco.assessment.card.service.CardService;
import com.credibanco.assessment.card.utils.CardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;
    @Override
    public ResponseDto createCard(CardCreateDto cardCreateDto) {
        Card newCard = CardUtils.mappingNewCard(cardCreateDto);

        if(!cardRepository.existsByPan(newCard.getPan())){
            cardRepository.save(newCard);
        }else{
            throw new CardFoundException(MessageResponse.FALLIDO.getMessage(), newCard.getPan());
        }

        return CardUtils.buildResponseDto("00",MessageResponse.EXITO.getMessage(), newCard.getCvv(), newCard.getPan());

    }

    @Override
    public ResponseDto enroledCard(CardRequestDto cardRequestDto) {
        Card card = cardRepository.findByPan(cardRequestDto.getPan())
                .orElseThrow(() -> new CardNotFoundException(MessageResponse.TARJETA_NO_EXISTE.getMessage(), cardRequestDto.getPan()));
        if(!card.getCvv().equals(cardRequestDto.getCvv())) {
            throw new InvalidCVVException(MessageResponse.VALIDACION_INVALIDA.getMessage(), cardRequestDto.getPan());
        }
        card.setEstado(StateCard.ENROLADA);
        cardRepository.save(card);
        return CardUtils.buildResponseDto("00",MessageResponse.EXITO.getMessage(), card.getPan());

    }

    @Override
    public ResponseCardDto getCard(String pan) {
        Card card = cardRepository.findByPan(pan)
                .orElseThrow(() -> new CardNotFoundException(MessageResponse.TARJETA_NO_EXISTE.getMessage(), pan));
        return CardUtils.buildResponseCardDto(card);
    }

    @Override
    public ResponseDto deleteCard(CardRequestDto cardRequestDto) {
        Card card = cardRepository.findByPanAndCvv(cardRequestDto.getPan(), cardRequestDto.getCvv())
                .orElseThrow(() -> new CardNotFoundException(MessageResponse.TARJETA_NO_ELIMINADA.getMessage()));
        cardRepository.delete(card);
        return CardUtils.buildResponseDto("00",MessageResponse.TARJETA_ELIMINADA.getMessage());
    }

}
