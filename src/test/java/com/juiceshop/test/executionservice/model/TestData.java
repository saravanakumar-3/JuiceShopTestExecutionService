package com.juiceshop.test.executionservice.model;

import io.cucumber.spring.ScenarioScope;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@ScenarioScope
@Component
public class TestData {
  public User user = new User();
  public Basket basket = new Basket();
}
