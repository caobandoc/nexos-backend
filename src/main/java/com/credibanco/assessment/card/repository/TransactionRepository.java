package com.credibanco.assessment.card.repository;

import com.credibanco.assessment.card.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
