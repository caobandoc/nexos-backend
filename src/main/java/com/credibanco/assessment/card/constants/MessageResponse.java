package com.credibanco.assessment.card.constants;

public enum MessageResponse {
    EXITO("Éxito"),
    FALLIDO("Fallido");

    private String message;
    MessageResponse(String fallido) {
        this.message = fallido;
    }

    public String getMessage() {
        return message;
    }
}
