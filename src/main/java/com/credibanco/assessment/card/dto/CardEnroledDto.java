package com.credibanco.assessment.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CardEnroledDto {
    @NotNull
    @Size(min = 16, max = 19)
    @Pattern(regexp = "[0-9]+", message = "Numero de tarjeta invalido")
    @JsonProperty("PAN")
    private String pan;
    @NotNull
    @Size(min = 3, max = 3)
    @Pattern(regexp = "[0-9]+", message = "CVV invalido")
    private String cvv;
}
