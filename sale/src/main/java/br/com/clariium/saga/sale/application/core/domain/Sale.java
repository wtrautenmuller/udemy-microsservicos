package br.com.clariium.saga.sale.application.core.domain;

import java.math.BigDecimal;

import br.com.clariium.saga.sale.application.core.domain.enums.SalesStatus;

public class Sale {
    

    private Integer id;

    private Integer productId;

    private Integer userId;

    private BigDecimal value;

    private SalesStatus status;

    private Integer quantity;

    public Sale(){
        
    }

    public Sale(Integer id, Integer productId, Integer userId, BigDecimal value, SalesStatus status, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.value = value;
        this.status = status;
        this.quantity = quantity;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public SalesStatus getStatus() {
        return this.status;
    }

    public void setStatus(SalesStatus status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    

    
}
