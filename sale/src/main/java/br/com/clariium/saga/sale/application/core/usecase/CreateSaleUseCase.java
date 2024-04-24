package br.com.clariium.saga.sale.application.core.usecase;

import br.com.clariium.saga.sale.application.core.domain.Sale;
import br.com.clariium.saga.sale.application.core.domain.enums.SaleEvent;
import br.com.clariium.saga.sale.application.core.domain.enums.SalesStatus;
import br.com.clariium.saga.sale.application.ports.in.CreateSaleInputPort;
import br.com.clariium.saga.sale.application.ports.out.SaveSaleOutputPort;
import br.com.clariium.saga.sale.application.ports.out.SendCreatedSaleOutputPort;

public class CreateSaleUseCase implements CreateSaleInputPort{

    private final SaveSaleOutputPort saveSaleOutputPort;

    private final SendCreatedSaleOutputPort sendCreatedSaleOutputPort;

    public CreateSaleUseCase(
        SaveSaleOutputPort saveSaleOutputPort,
        SendCreatedSaleOutputPort sendCreatedSaleOutputPort)
        {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreatedSaleOutputPort = sendCreatedSaleOutputPort;
    }
    

    @Override
    public void create(Sale sale){
        sale.setStatus(SalesStatus.PENDING);

        var saleResponse = saveSaleOutputPort.save(sale);
        sendCreatedSaleOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);

    }
}
