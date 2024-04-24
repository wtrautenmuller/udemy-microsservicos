package br.com.clariium.saga.sale.adapters.in.controller.mapper;

import org.mapstruct.Mapper;

import br.com.clariium.saga.sale.adapters.in.controller.request.SaleRequest;
import br.com.clariium.saga.sale.application.core.domain.Sale;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);
    
}
