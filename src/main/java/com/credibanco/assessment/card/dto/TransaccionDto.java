package com.credibanco.assessment.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class TransaccionDto {
    @NotNull
    @JsonProperty("PAN")
    private String pan;
    @NotNull
    @Size(min = 6, max = 6)
    @Pattern(regexp = "\\d", message = "Codigo de autorizacion invalido")
    private String referencia;
    @NotNull
    private Double valor;
    @NotNull
    private String direccion;

}
