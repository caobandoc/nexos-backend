package com.credibanco.assessment.card.constants;

public enum StateTransaction {
    APROBADA("Aprobada"),
    RECHAZADA("Rechazada");

    private String state;

    private StateTransaction(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
