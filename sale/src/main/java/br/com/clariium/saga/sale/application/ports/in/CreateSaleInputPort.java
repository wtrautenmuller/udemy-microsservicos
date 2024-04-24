package br.com.clariium.saga.sale.application.ports.in;

import br.com.clariium.saga.sale.application.core.domain.Sale;

public interface CreateSaleInputPort {
    
    void create(Sale sale);
}
