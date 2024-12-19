package com.juiceshop.test.executionservice.config;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {
  @Bean
  @ScenarioScope
  public WebDriver getWebDriver(@Value("${automation.browser}") String browser) {
    WebDriver driver;
    switch (browser) {
      case "chrome":
        driver = new ChromeDriver();
        break;
      case "firefox":
        driver = new FirefoxDriver();
        break;
      default:
        throw new IllegalArgumentException("Browser '" + browser + "' is not supported");
    }
    return driver;
  }
}
