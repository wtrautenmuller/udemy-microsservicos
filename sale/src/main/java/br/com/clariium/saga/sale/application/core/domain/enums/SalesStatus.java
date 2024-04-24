package br.com.clariium.saga.sale.application.core.domain.enums;

import java.util.Arrays;

public enum SalesStatus {
    
    PENDING(1),

    FINALIZED(2),

    CANCELED(3);

    private final Integer statusId;

    SalesStatus(Integer statusId){
        this.statusId = statusId;
    }

    public Integer getStatusID(){
        return statusId;
    }

    public static SalesStatus toEnum(Integer id){
        if(id == null)return null;

        return Arrays.stream(SalesStatus.values())
                .filter(status -> id.equals(status.getStatusID()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Id do status é inválido " + id));
    }
}
