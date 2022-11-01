package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.ListTransResponseDto;
import com.credibanco.assessment.card.dto.ResponseTranDto;
import com.credibanco.assessment.card.dto.TransDelDto;
import com.credibanco.assessment.card.dto.TransaccionDto;

import java.util.List;

public interface TransactionService {
    ResponseTranDto createTransactionCard(TransaccionDto transaccionDto);

    ResponseTranDto deleteTransaction(TransDelDto transDelDto);

    List<ListTransResponseDto> getTransaction(String pan);
}
