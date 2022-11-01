package com.credibanco.assessment.card.repository;

import com.credibanco.assessment.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    boolean existsByPan(String pan);
    Optional<Card> findByPan(String pan);
    Optional<Card> findByPanAndCvv(String pan, String cvv);
}
