package br.com.clariium.saga.sale.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.clariium.saga.sale.adapters.FindSaleByIdAdapter;
import br.com.clariium.saga.sale.application.core.usecase.FindSaleByIdUseCase;

@Configuration
public class FindSaleByIdConfig {
    
    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(
        FindSaleByIdAdapter findSaleByIdAdapter
    ){
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }
}
