package com.juiceshop.test.executionservice.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Basket {
  private List<Item> items = new ArrayList<>();
  private BigDecimal totalPrice;
}
