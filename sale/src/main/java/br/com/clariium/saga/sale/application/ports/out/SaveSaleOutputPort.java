package br.com.clariium.saga.sale.application.ports.out;

import br.com.clariium.saga.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {
    

    Sale save(Sale sale);
}
