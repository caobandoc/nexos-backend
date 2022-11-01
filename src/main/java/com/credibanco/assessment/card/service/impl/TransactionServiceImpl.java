package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.constants.MessageResponse;
import com.credibanco.assessment.card.constants.StateCard;
import com.credibanco.assessment.card.constants.StateTransaction;
import com.credibanco.assessment.card.dto.ResponseTranDto;
import com.credibanco.assessment.card.dto.TransDelDto;
import com.credibanco.assessment.card.dto.ListTransResponseDto;
import com.credibanco.assessment.card.dto.TransaccionDto;
import com.credibanco.assessment.card.exceptions.CardNotEnroledException;
import com.credibanco.assessment.card.exceptions.CardNotFoundException;
import com.credibanco.assessment.card.exceptions.TransactionNotCancelException;
import com.credibanco.assessment.card.exceptions.TransactionNotFoundException;
import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.model.Transaction;
import com.credibanco.assessment.card.repository.CardRepository;
import com.credibanco.assessment.card.repository.TransactionRepository;
import com.credibanco.assessment.card.service.TransactionService;
import com.credibanco.assessment.card.utils.ResponseUtil;
import com.credibanco.assessment.card.utils.TransaccionUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private CardRepository cardRepository;
    @Override
    public ResponseTranDto createTransactionCard(TransaccionDto transaccionDto) {
        Card card = cardRepository.findByPan(transaccionDto.getPan())
                .orElseThrow(() -> new CardNotFoundException(MessageResponse.TARJETA_NO_EXISTE.getMessage(), transaccionDto.getPan()));
        if(card.getEstado().equals(StateCard.ENROLADA)){
            transactionRepository.save(TransaccionUtils.buildTransaccionSuccess(transaccionDto, card));
            return ResponseUtil.buildResponseTranDto("00", MessageResponse.COMPRA_EXITOSA.getMessage(), StateTransaction.APROBADA.getState(), transaccionDto.getReferencia());
        }else{
            transactionRepository.save(TransaccionUtils.buildTransaccionFail(transaccionDto, card));
            throw new CardNotEnroledException(MessageResponse.TARJETA_NO_ENROLADA.getMessage(), transaccionDto.getReferencia());
        }
    }

    @Override
    public ResponseTranDto deleteTransaction(TransDelDto transDelDto) {
        Transaction transaction = transactionRepository.findByReferencia(transDelDto.getReferencia())
                .orElseThrow(() -> new TransactionNotFoundException(MessageResponse.NUMERO_REFERENCIA_INVALIDO.getMessage(), transDelDto.getReferencia()));
        // si no han pasado 5 minutos de la creacion de la transaccion puede ser cancelada
        if(TransaccionUtils.validateTimeTransaction(transaction.getCreado())) {
            transactionRepository.delete(transaction);
            return ResponseUtil.buildResponseTranDto("00", MessageResponse.COMPRA_ANULADA.getMessage(), transDelDto.getReferencia());
        }else{
            throw new TransactionNotCancelException(MessageResponse.NUMERO_REFERENCIA_INVALIDO.getMessage(), transDelDto.getReferencia());
        }
    }

    @Override
    public List<ListTransResponseDto> getTransaction(String pan) {
        Card card = cardRepository.findByPan(pan)
                .orElseThrow(() -> new CardNotFoundException(MessageResponse.TARJETA_NO_EXISTE.getMessage(), pan));
        return TransaccionUtils.buildTransResponseDto(transactionRepository.findByTarjeta(card));
    }
}
