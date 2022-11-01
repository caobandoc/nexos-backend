package com.credibanco.assessment.card.dto;

import com.credibanco.assessment.card.constants.TypeCard;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CardCreateDto {
    @NotNull
    @Size(min = 16, max = 19)
    @Pattern(regexp = "[0-9]+", message = "Numero de tarjeta invalido")
    @JsonProperty("PAN")
    private String pan;
    @NotNull
    private String titular;
    @NotNull
    @Size(min = 10, max = 15)
    private String cedula;
    @NotNull
    private TypeCard tipo;
    @NotNull
    @Size(min = 10, max = 10)
    private String telefono;
}
