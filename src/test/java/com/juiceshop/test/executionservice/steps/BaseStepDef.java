package com.juiceshop.test.executionservice.steps;

import com.github.javafaker.Faker;
import com.juiceshop.test.executionservice.config.TestData;
import com.juiceshop.test.executionservice.model.Item;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;

import org.awaitility.Awaitility;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseStepDef {
  @Autowired protected TestData testData;
  protected Faker faker = new Faker();

  public static BigDecimal calculateTotalPrice(List<Item> items) {
    return items.stream()
            .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
            .reduce(BigDecimal::add)
            .get();
  }
}
