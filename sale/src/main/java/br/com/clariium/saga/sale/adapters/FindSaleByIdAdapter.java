package br.com.clariium.saga.sale.adapters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.clariium.saga.sale.adapters.out.repository.SaleRepository;
import br.com.clariium.saga.sale.adapters.out.repository.mapper.SaleEntityMapper;
import br.com.clariium.saga.sale.application.core.domain.Sale;
import br.com.clariium.saga.sale.application.ports.out.FindSaleByIdOutputPort;

@Component
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort{

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Optional<Sale> find(Integer id) {
        var saleEntity = saleRepository.findById(id);
        return saleEntity.map(saleEntityMapper::toSale);
    }
    
}
