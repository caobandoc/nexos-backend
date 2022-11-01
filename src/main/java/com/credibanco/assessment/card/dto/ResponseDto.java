package com.credibanco.assessment.card.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
    @JsonProperty("Código de respuesta")
    private String code;
    @JsonProperty("Mensaje")
    private String message;
    @JsonProperty("Número de validación")
    private String cvv;
    @JsonProperty("PAN")
    private String pan;
}
