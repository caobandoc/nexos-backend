package com.credibanco.assessment.card.model;

import com.credibanco.assessment.card.constants.StateTransaction;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date creado;
    private StateTransaction estado;

}
