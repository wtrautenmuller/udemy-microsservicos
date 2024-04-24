package br.com.clariium.saga.sale.application.core.usecase;

import br.com.clariium.saga.sale.application.core.domain.Sale;
import br.com.clariium.saga.sale.application.core.domain.enums.SalesStatus;
import br.com.clariium.saga.sale.application.ports.in.FinalizeSaleInputPort;
import br.com.clariium.saga.sale.application.ports.in.FindSaleByIdInputPort;
import br.com.clariium.saga.sale.application.ports.out.SaveSaleOutputPort;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort{

    private final FindSaleByIdInputPort findSaleByIdInputPort; 

    private final SaveSaleOutputPort saveSaleOutputPort;

    public FinalizeSaleUseCase(
        FindSaleByIdInputPort findSaleByIdInputPort,
        SaveSaleOutputPort saveSaleOutputPort
    ){
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }
    
    @Override
    public void finalize(Sale sale){
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SalesStatus.FINALIZED);
        saveSaleOutputPort.save(saleResponse);
    }
}
