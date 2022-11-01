package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.constants.MessageResponse;
import com.credibanco.assessment.card.dto.CardCreateDto;
import com.credibanco.assessment.card.dto.ResponseDto;
import com.credibanco.assessment.card.exceptions.CardFoundException;
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
        String panMask = CardUtils.enmascararPan(newCard.getPan());

        if(!cardRepository.existsByPan(newCard.getPan())){
            cardRepository.save(newCard);
        }else{
            throw new CardFoundException(MessageResponse.FALLIDO.getMessage(), panMask);
        }

        return CardUtils.buildResponseDto("00",MessageResponse.EXITO.getMessage(), newCard.getCvv(), newCard.getPan());

    }

}
