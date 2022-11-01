package com.credibanco.assessment.card.exceptions;

public class CardFoundException extends RuntimeException {

    private String pan;
    public CardFoundException(String message, String pan) {
        super(message);
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }
}
