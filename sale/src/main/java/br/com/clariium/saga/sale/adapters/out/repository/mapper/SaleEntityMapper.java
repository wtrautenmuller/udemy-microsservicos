package br.com.clariium.saga.sale.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import br.com.clariium.saga.sale.adapters.out.repository.entity.SaleEntity;
import br.com.clariium.saga.sale.application.core.domain.Sale;
import br.com.clariium.saga.sale.application.core.domain.enums.SalesStatus;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {

    @Mapping(source = "status",target = "statusId",qualifiedByName =  "setStatusId")
    SaleEntity toSaleEntity(Sale sale);

    @Named("setStatusId")
    default Integer setStatusId(SalesStatus salesStatus){
        return salesStatus.getStatusID();
    }

    @Mapping(source = "statusId", target = "status", qualifiedByName = "setStatusId")
    Sale toSale(SaleEntity saleEntity);

    @Named("setStatusId")
    default SalesStatus setStatus(Integer salesStatusId){
        return SalesStatus.toEnum(salesStatusId);
    }


    
}
