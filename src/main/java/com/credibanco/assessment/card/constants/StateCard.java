package com.credibanco.assessment.card.constants;

public enum StateCard {
    CREADA("Creada"),ENROLADA("Enrolada");

    private String state;

    private StateCard(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
