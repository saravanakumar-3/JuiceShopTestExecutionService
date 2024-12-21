package com.juiceshop.test.executionservice.steps;

import com.github.javafaker.Faker;
import com.juiceshop.test.executionservice.model.Item;
import com.juiceshop.test.executionservice.model.TestData;
import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseStepDef {
  @Autowired protected TestData testData;
  protected static Faker faker = new Faker();

  public static BigDecimal calculateTotalPrice(List<Item> items) {
    return items.stream()
        .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
        .reduce(BigDecimal::add)
        .get();
  }

  public static String getRandomNumber(int noOfDigits) {
    return faker.number().digits(noOfDigits).replaceFirst("0", "1");
  }
}
