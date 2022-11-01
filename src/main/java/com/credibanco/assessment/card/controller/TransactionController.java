package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.dto.ListTransResponseDto;
import com.credibanco.assessment.card.dto.ResponseTranDto;
import com.credibanco.assessment.card.dto.TransDelDto;
import com.credibanco.assessment.card.dto.TransaccionDto;
import com.credibanco.assessment.card.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<ResponseTranDto> createTransactionCard(@Valid @RequestBody TransaccionDto transRequestDto) {
        return new ResponseEntity<>(transactionService.createTransactionCard(transRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<ResponseTranDto> createTransactionCard(@Valid @RequestBody TransDelDto transDelDto) {
        return ResponseEntity.ok(transactionService.deleteTransaction(transDelDto));
    }

    @GetMapping("/{pan}")
    public ResponseEntity<List<ListTransResponseDto>> getTransaction(@PathVariable String pan) {
        return ResponseEntity.ok(transactionService.getTransaction(pan));
    }
}
