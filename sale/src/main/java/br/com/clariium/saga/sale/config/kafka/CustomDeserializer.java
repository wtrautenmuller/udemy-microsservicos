package br.com.clariium.saga.sale.config.kafka;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.clariium.saga.sale.adapters.out.message.SaleMessage;

public class CustomDeserializer implements Deserializer<SaleMessage>{

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SaleMessage deserialize(String topic,byte[] data){
        try{
            if(data ==null){
                return null;
            }
            return objectMapper.readValue(new String(data,"ÜTF-8"), SaleMessage.class);
        }catch(Exception e){
            throw new SerializationException("Error when serializing SaleMessage to byte[]");
        }
    }
    
}
