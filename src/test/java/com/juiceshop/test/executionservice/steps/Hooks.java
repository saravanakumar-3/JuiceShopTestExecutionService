package com.juiceshop.test.executionservice.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {
  @Autowired protected WebDriver driver;

  @Before
  public void beforeScenario() {
    driver.manage().window().maximize();
  }

  @After
  public void afterScenario() {
    driver.quit();
  }
}
