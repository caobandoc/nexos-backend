package com.credibanco.assessment.card.model;

import com.credibanco.assessment.card.constants.StateCard;
import com.credibanco.assessment.card.constants.TypeCard;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cards")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String pan;
    private String titular;
    private String cedula;
    private TypeCard tipo;
    private String telefono;
    private String cvv;
    private StateCard estado;
    @OneToMany(mappedBy = "tarjeta", cascade = CascadeType.ALL)
    private List<Transaction> transacciones;
}
