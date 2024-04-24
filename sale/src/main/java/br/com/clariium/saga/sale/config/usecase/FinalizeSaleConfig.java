package br.com.clariium.saga.sale.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.clariium.saga.sale.adapters.out.SaveSalesAdapter;
import br.com.clariium.saga.sale.application.core.usecase.FinalizeSaleUseCase;
import br.com.clariium.saga.sale.application.core.usecase.FindSaleByIdUseCase;

@Configuration
public class FinalizeSaleConfig {
    
    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(
        FindSaleByIdUseCase findSaleByIdUseCase,
        SaveSalesAdapter saveSalesAdapter
    ){
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSalesAdapter);
    }
}
