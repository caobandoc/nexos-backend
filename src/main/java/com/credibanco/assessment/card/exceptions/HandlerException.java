package com.credibanco.assessment.card.exceptions;

import com.credibanco.assessment.card.constants.StateTransaction;
import com.credibanco.assessment.card.dto.ResponseDto;
import com.credibanco.assessment.card.dto.ResponseTranDto;
import com.credibanco.assessment.card.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerException {

    public static final String NOT_FOUND = "01";
    public static final String ERROR = "02";

    @ExceptionHandler(CardFoundException.class)
    public ResponseEntity<ResponseDto> cardFoundException(HttpServletRequest request, CardFoundException e) {
        ResponseDto responseDto = ResponseUtil.buildResponseDto(NOT_FOUND, e.getMessage(), e.getPan());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<ResponseDto> cardNotFoundException(HttpServletRequest request, CardNotFoundException e) {
        ResponseDto responseDto;
        if (e.getPan() != null) {
            responseDto = ResponseUtil.buildResponseDto(NOT_FOUND, e.getMessage(), e.getPan());
        }else{
            responseDto = ResponseUtil.buildResponseDto(NOT_FOUND, e.getMessage());
        }
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCVVException.class)
    public ResponseEntity<ResponseDto> invalidCVVException(HttpServletRequest request, InvalidCVVException e) {
        ResponseDto responseDto = ResponseUtil.buildResponseDto(ERROR, e.getMessage(), e.getPan());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CardNotEnroledException.class)
    public ResponseEntity<ResponseTranDto> cardNotEnroledException(HttpServletRequest request, CardNotEnroledException e) {
        ResponseTranDto responseTranDto = ResponseUtil.buildResponseTranDto(ERROR, e.getMessage(), StateTransaction.RECHAZADA.getState(), e.getReference());
        return new ResponseEntity<>(responseTranDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<ResponseTranDto> transactionNotFoundException(HttpServletRequest request, TransactionNotFoundException e) {
        ResponseTranDto responseTranDto = ResponseUtil.buildResponseTranDto(NOT_FOUND, e.getMessage(), e.getReference());
        return new ResponseEntity<>(responseTranDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionNotCancelException.class)
    public ResponseEntity<ResponseTranDto> transactionNotCancelException(HttpServletRequest request, TransactionNotCancelException e) {
        ResponseTranDto responseTranDto = ResponseUtil.buildResponseTranDto(ERROR, e.getMessage(), e.getReference());
        return new ResponseEntity<>(responseTranDto, HttpStatus.BAD_REQUEST);
    }
}
