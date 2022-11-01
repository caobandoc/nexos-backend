package com.credibanco.assessment.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseCardDto {
    @JsonProperty("PAN enmascarado")
    private String pan;
    private String titular;
    @JsonProperty("cédula")
    private String cedula;
    @JsonProperty("teléfono")
    private String telefono;
    private String estado;

}
