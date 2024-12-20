package com.juiceshop.test.executionservice.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  protected final WebDriver driver;
  protected final JavascriptExecutor js;
  protected final Wait<WebDriver> wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    js = (JavascriptExecutor) driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
  }

  protected WebElement findElement(By by) {
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    return driver.findElement(by);
  }

  protected List<WebElement> findElements(By by) {
    return driver.findElements(by);
  }

  protected void click(By by) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    wait.until(ExpectedConditions.elementToBeClickable(by));
    findElement(by).click();
  }

  protected void sendKeys(By by, String value) {
    findElement(by).sendKeys(value);
  }
}
