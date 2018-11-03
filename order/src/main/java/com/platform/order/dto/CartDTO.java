package com.platform.order.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartDTO implements Serializable {
    private String productId;
    private Integer quantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
