package com.juiceshop.test.executionservice.config;

import io.cucumber.spring.ScenarioScope;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {
  @Bean
  @ScenarioScope
  public RemoteWebDriver getWebDriver(@Value("${automation.browser}") String browser) {
    RemoteWebDriver driver;
    switch (browser) {
      case "chrome":
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(chromeOptions);
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
