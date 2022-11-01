package com.credibanco.assessment.card.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ListTransResponseDto {
    private String referencia;
    private Double valor;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date creado;
    private String estado;
}
