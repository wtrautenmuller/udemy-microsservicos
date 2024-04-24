package br.com.clariium.saga.sale.application.core.usecase;

import br.com.clariium.saga.sale.application.core.domain.Sale;
import br.com.clariium.saga.sale.application.ports.in.FindSaleByIdInputPort;
import br.com.clariium.saga.sale.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(
        FindSaleByIdOutputPort findSaleByIdOutputPort
    ){
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }
    
    @Override
    public Sale find(Integer id){
        return findSaleByIdOutputPort.find(id)
            .orElseThrow(()-> new RuntimeException("Venda não encontrada"));
    }
}
