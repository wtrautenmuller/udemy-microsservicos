package br.com.clariium.saga.sale.application.ports.out;

import br.com.clariium.saga.sale.application.core.domain.Sale;
import br.com.clariium.saga.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {
    
    void send(Sale sale, SaleEvent event);

}
