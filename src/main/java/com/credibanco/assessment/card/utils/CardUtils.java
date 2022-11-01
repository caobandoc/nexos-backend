package com.credibanco.assessment.card.utils;

import com.credibanco.assessment.card.constants.StateCard;
import com.credibanco.assessment.card.dto.CardCreateDto;
import com.credibanco.assessment.card.dto.ResponseCardDto;
import com.credibanco.assessment.card.model.Card;

import java.security.SecureRandom;
import java.util.Random;

public class CardUtils {

    private CardUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Card mappingNewCard(CardCreateDto cardCreateDto) {
        return Card.builder()
                .pan(cardCreateDto.getPan())
                .titular(cardCreateDto.getTitular())
                .cedula(cardCreateDto.getCedula())
                .tipo(cardCreateDto.getTipo())
                .telefono(cardCreateDto.getTelefono())
                .cvv(generateCvv())
                .estado(StateCard.CREADA)
                .build();

    }

    private static String generateCvv(){
        Random random = new SecureRandom();
        int numero = random.nextInt(999);
        return String.format("%03d", numero);
    }

    static String enmascararPan(String pan){
        StringBuilder panEnmascarado = new StringBuilder();
        panEnmascarado.append(pan, 0, 6);
        for (int i = 0; i < pan.length() - 10; i++) {
            panEnmascarado.append("*");
        }
        panEnmascarado.append(pan.substring(pan.length() - 4));
        return panEnmascarado.toString();
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
