package com.credibanco.assessment.card.constants;

public enum MessageResponse {
    EXITO("Éxito"),
    FALLIDO("Fallido"),
    TARJETA_NO_EXISTE("La tarjeta no existe"),
    VALIDACION_INVALIDA("Numero de validacion invalido"),
    TARJETA_NO_ELIMINADA("No se ha eliminado la tarjeta"),
    TARJETA_ELIMINADA("Se ha eliminado la tarjeta"),
    COMPRA_EXITOSA("Compra exitosa"),
    TARJETA_NO_ENROLADA("Tarjeta no enrolada");

    private String message;
    MessageResponse(String fallido) {
        this.message = fallido;
    }

    public String getMessage() {
        return message;
    }
}
