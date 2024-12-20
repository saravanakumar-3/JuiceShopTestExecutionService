package com.juiceshop.test.executionservice.config;

import com.juiceshop.test.executionservice.model.User;
import io.cucumber.spring.ScenarioScope;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@ScenarioScope
@Component
public class TestData {
  public User user;
}
