package com.credibanco.assessment.card.utils;

import com.credibanco.assessment.card.dto.ResponseDto;
import com.credibanco.assessment.card.dto.ResponseTranDto;

public class ResponseUtil {

    private ResponseUtil() {
        throw new IllegalStateException("Utility class");
    }
    public static ResponseDto buildResponseDto(String code, String message, String cvv, String pan){
        return ResponseDto.builder()
                .code(code)
                .message(message)
                .cvv(cvv)
                .pan(CardUtils.enmascararPan(pan))
                .build();
    }

    public static ResponseDto buildResponseDto(String code, String message, String pan){
        return ResponseDto.builder()
                .code(code)
                .message(message)
                .pan(CardUtils.enmascararPan(pan))
                .build();
    }

    public static ResponseDto buildResponseDto(String code, String message){
        return ResponseDto.builder()
                .code(code)
                .message(message)
                .build();
    }

    public static ResponseTranDto buildResponseTranDto(String code, String message, String state, String reference){
        return ResponseTranDto.builder()
                .code(code)
                .message(message)
                .state(state)
                .reference(reference)
                .build();
    }
}
