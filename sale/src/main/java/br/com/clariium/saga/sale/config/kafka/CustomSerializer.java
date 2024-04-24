package br.com.clariium.saga.sale.config.kafka;


import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.clariium.saga.sale.adapters.out.message.SaleMessage;

public class CustomSerializer implements Serializer<SaleMessage>{

    private final ObjectMapper objectMapper = new ObjectMapper();

    public byte[] serialize(String s,SaleMessage saleMessage){
        try{
            if(saleMessage ==null){
                return null;
            }
            return objectMapper.writeValueAsBytes(saleMessage);
        }catch(Exception e){
            throw new SerializationException("Error when serializing SaleMessage to byte[]");
        }
    }
    
}
