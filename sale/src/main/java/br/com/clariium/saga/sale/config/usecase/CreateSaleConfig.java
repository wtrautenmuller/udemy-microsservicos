package br.com.clariium.saga.sale.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.clariium.saga.sale.adapters.out.SendCreatedSaleAdapter;
import br.com.clariium.saga.sale.application.core.usecase.CreateSaleUseCase;
import br.com.clariium.saga.sale.application.ports.out.SaveSaleOutputPort;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
        SaveSaleOutputPort saveSaleOutputPort,
        SendCreatedSaleAdapter sendCreatedSaleAdapter 
    ){
        return new CreateSaleUseCase(saveSaleOutputPort, sendCreatedSaleAdapter);


    }
    
}
