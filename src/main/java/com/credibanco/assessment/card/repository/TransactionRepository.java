package com.credibanco.assessment.card.repository;

import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByReferencia(String referencia);

    List<Transaction> findByTarjeta(Card card);
}
