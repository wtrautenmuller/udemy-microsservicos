package br.com.clariium.saga.sale.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import br.com.clariium.saga.sale.adapters.out.message.SaleMessage;
import br.com.clariium.saga.sale.application.core.domain.Sale;
import br.com.clariium.saga.sale.application.core.domain.enums.SaleEvent;
import br.com.clariium.saga.sale.application.ports.out.SendCreatedSaleOutputPort;

@Component
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort{

    @Autowired
    private KafkaTemplate<String,SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale,event);

        kafkaTemplate.send("tp-saga-sale",saleMessage);
        
    }


    
}
