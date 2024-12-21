package com.juiceshop.test.executionservice.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class Item {
    private String name;
    private int quantity;
    private BigDecimal price;

    public void addQuantity(int count) {
        quantity = quantity + count;
    }

    public void minusQuantity(int count) {
        quantity = quantity - count;
    }
}
