package com.credibanco.assessment.card.exceptions;

public class CardNotEnroledException extends RuntimeException {

    private final String reference;
    public CardNotEnroledException(String message, String reference) {
        super(message);
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }
}
