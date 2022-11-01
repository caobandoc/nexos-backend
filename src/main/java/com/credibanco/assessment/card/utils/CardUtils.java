package com.credibanco.assessment.card.utils;

import com.credibanco.assessment.card.constants.StateCard;
import com.credibanco.assessment.card.dto.CardCreateDto;
import com.credibanco.assessment.card.dto.ResponseCardDto;
import com.credibanco.assessment.card.dto.ResponseDto;
import com.credibanco.assessment.card.model.Card;

public class CardUtils {

    public static Card mappingNewCard(CardCreateDto cardCreateDto) {
        Card newCard = Card.builder()
                .pan(cardCreateDto.getPan())
                .titular(cardCreateDto.getTitular())
                .cedula(cardCreateDto.getCedula())
                .tipo(cardCreateDto.getTipo())
                .telefono(cardCreateDto.getTelefono())
                .cvv(generateCvv())
                .estado(StateCard.CREADA)
                .build();
        return newCard;

    }

    private static String generateCvv(){
        int numero = (int) (Math.random() * 999) + 1;
        String cvv = String.valueOf(numero);
        while (cvv.length() < 3) {
            cvv = "0" + cvv;
        }
        return cvv;

    }

    public static ResponseDto buildResponseDto(String code, String message, String cvv, String pan){
        return ResponseDto.builder()
                .code(code)
                .message(message)
                .cvv(cvv)
                .pan(enmascararPan(pan))
                .build();
    }

    public static ResponseDto buildResponseDto(String code, String message, String pan){
        return ResponseDto.builder()
                .code(code)
                .message(message)
                .pan(enmascararPan(pan))
                .build();
    }

    public static ResponseDto buildResponseDto(String code, String message){
        return ResponseDto.builder()
                .code(code)
                .message(message)
                .build();
    }

    private static String enmascararPan(String pan){
        return pan.substring(0, 6) + "********" + pan.substring(pan.length() - 4);
    }

    public static ResponseCardDto buildResponseCardDto(Card card) {
        return ResponseCardDto.builder()
                .pan(enmascararPan(card.getPan()))
                .titular(card.getTitular())
                .cedula(card.getCedula())
                .telefono(card.getTelefono())
                .estado(card.getEstado().getState())
                .build();
    }
}
