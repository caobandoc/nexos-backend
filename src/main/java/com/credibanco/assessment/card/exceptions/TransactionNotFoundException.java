package com.credibanco.assessment.card.exceptions;

public class TransactionNotFoundException extends RuntimeException {

    private String reference;
    public TransactionNotFoundException(String message, String reference) {
        super(message);
        this.reference = reference;
    }

    public TransactionNotFoundException(String message) {
        super(message);
    }

    public String getReference() {
        return reference;
    }
}
