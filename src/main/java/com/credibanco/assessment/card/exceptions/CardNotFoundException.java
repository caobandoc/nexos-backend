package com.credibanco.assessment.card.exceptions;

public class CardNotFoundException extends RuntimeException {

    private String pan;
    public CardNotFoundException(String message, String pan) {
        super(message);
        this.pan = pan;
    }

    public CardNotFoundException(String message) {
        super(message);
    }

    public String getPan() {
        return pan;
    }
}
