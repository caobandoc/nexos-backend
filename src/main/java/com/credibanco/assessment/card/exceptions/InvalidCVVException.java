package com.credibanco.assessment.card.exceptions;

public class InvalidCVVException extends RuntimeException {

    private String pan;
    public InvalidCVVException(String message, String pan) {
        super(message);
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }
}
