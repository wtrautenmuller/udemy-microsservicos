package br.com.clariium.saga.sale.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.clariium.saga.sale.adapters.out.repository.SaleRepository;
import br.com.clariium.saga.sale.adapters.out.repository.mapper.SaleEntityMapper;
import br.com.clariium.saga.sale.application.core.domain.Sale;
import br.com.clariium.saga.sale.application.ports.out.SaveSaleOutputPort;

@Component
public class SaveSalesAdapter implements SaveSaleOutputPort{

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale sale) {
        
        var saleEntity = saleEntityMapper.toSaleEntity(sale);
        var saleEntityResponse = saleRepository.save(saleEntity);
             
        return saleEntityMapper.toSale(saleEntityResponse);
    }
    
}
