package com.credibanco.assessment.card.exceptions;

import com.credibanco.assessment.card.dto.ResponseDto;
import com.credibanco.assessment.card.utils.CardUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(CardFoundException.class)
    public ResponseEntity<ResponseDto> cardFoundException(HttpServletRequest request, CardFoundException e) {
        ResponseDto responseDto = CardUtils.buildResponseDto("01", e.getMessage(), e.getPan());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<ResponseDto> cardNotFoundException(HttpServletRequest request, CardNotFoundException e) {
        ResponseDto responseDto = CardUtils.buildResponseDto("01", e.getMessage(), e.getPan());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCVVException.class)
    public ResponseEntity<ResponseDto> invalidCVVException(HttpServletRequest request, InvalidCVVException e) {
        ResponseDto responseDto = CardUtils.buildResponseDto("02", e.getMessage(), e.getPan());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
