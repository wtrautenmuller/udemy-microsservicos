package br.com.clariium.saga.sale.application.ports.out;

import java.util.Optional;

import br.com.clariium.saga.sale.application.core.domain.Sale;

public interface FindSaleByIdOutputPort {
    
    Optional<Sale> find(final Integer id); 

}
