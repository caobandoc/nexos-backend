package com.credibanco.assessment.card.model;

import com.credibanco.assessment.card.constants.StateTransaction;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaccions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String referencia;
    private Double valor;
    @ManyToOne
    private Card tarjeta;
    private Date created;
    private StateTransaction state;

}
