package com.credibanco.assessment.card.constants;

public enum MessageResponse {
    EXITO("Éxito"),
    FALLIDO("Fallido"),
    TARJETA_NO_EXISTE("La tarjeta no existe"),
    VALIDACION_INVALIDA("Numero de validacion invalido");

    private String message;
    MessageResponse(String fallido) {
        this.message = fallido;
    }

    public String getMessage() {
        return message;
    }
}
