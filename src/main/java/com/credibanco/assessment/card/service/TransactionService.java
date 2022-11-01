package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.ResponseTranDto;
import com.credibanco.assessment.card.dto.TransaccionDto;

public interface TransactionService {
    ResponseTranDto createTransactionCard(TransaccionDto transaccionDto);
}
