package com.juiceshop.test.executionservice.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Basket {
  private List<Item> items = new ArrayList<>();
  private BigDecimal totalPrice;
}
