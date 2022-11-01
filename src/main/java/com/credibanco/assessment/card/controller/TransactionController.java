package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.dto.ResponseTranDto;
import com.credibanco.assessment.card.dto.TransaccionDto;
import com.credibanco.assessment.card.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<ResponseTranDto> createTransactionCard(@Valid @RequestBody TransaccionDto transRequestDto) {
        return ResponseEntity.ok(transactionService.createTransactionCard(transRequestDto));
    }
}
