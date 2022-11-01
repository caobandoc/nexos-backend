package com.credibanco.assessment.card.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseCardDto {
    private String pan;
    private String titular;
    private String cedula;
    private String telefono;
    private String estado;

}
