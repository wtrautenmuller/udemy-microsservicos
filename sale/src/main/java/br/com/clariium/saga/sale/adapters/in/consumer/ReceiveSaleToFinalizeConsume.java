package br.com.clariium.saga.sale.adapters.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.clariium.saga.sale.adapters.out.message.SaleMessage;
import br.com.clariium.saga.sale.application.core.domain.enums.SaleEvent;
import br.com.clariium.saga.sale.application.ports.in.FinalizeSaleInputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReceiveSaleToFinalizeConsume {

    @Autowired
    private FinalizeSaleInputPort finalizeSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale",groupId = "sale-finalize")
    public void receive(SaleMessage saleMessage){
        if(SaleEvent.VALIDATED_PAYMENT.equals(saleMessage.getEvent())){
            log.info("Finalizando a venda");
            finalizeSaleInputPort.finalize(saleMessage.getSale());
            log.info("Venda finalizada com sucesso.");
        }
    }

    
}
