package com.credibanco.assessment.card.utils;

import com.credibanco.assessment.card.constants.StateTransaction;
import com.credibanco.assessment.card.dto.ListTransResponseDto;
import com.credibanco.assessment.card.dto.TransaccionDto;
import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.model.Transaction;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TransaccionUtils {

    private TransaccionUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Transaction buildTransaccionSuccess(TransaccionDto transaccionDto, Card card) {
        return Transaction.builder()
                .referencia(transaccionDto.getReferencia())
                .valor(transaccionDto.getValor())
                .tarjeta(card)
                .creado(new Date())
                .estado(StateTransaction.APROBADA)
                .build();
    }

    public static Transaction buildTransaccionFail(TransaccionDto transaccionDto, Card card) {
        return Transaction.builder()
                .referencia(transaccionDto.getReferencia())
                .valor(transaccionDto.getValor())
                .tarjeta(card)
                .creado(new Date())
                .estado(StateTransaction.RECHAZADA)
                .build();
    }

    public static boolean validateTimeTransaction(Date date) {
        Date fechaActual = new Date(System.currentTimeMillis());
        long diferencia = fechaActual.getTime() - date.getTime();
        long minutos = (diferencia / 1000) / 60;
        return minutos < 5;
    }

    public static List<ListTransResponseDto> buildTransResponseDto(List<Transaction> byCard) {
        return byCard.stream().map(transaction -> ListTransResponseDto.builder()
                .referencia(transaction.getReferencia())
                .valor(transaction.getValor())
                .creado(transaction.getCreado())
                .estado(transaction.getEstado().name())
                .build()).collect(Collectors.toList());
    }
}
