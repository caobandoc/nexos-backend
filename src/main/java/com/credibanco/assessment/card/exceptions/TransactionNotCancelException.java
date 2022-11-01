package com.credibanco.assessment.card.exceptions;

public class TransactionNotCancelException extends RuntimeException {

    private String reference;
    public TransactionNotCancelException(String message, String reference) {
        super(message);
        this.reference = reference;
    }

    public TransactionNotCancelException(String message) {
        super(message);
    }

    public String getReference() {
        return reference;
    }
}
