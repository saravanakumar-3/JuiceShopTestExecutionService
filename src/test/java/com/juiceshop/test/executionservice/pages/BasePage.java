package com.juiceshop.test.executionservice.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  protected final WebDriver driver;
  protected final JavascriptExecutor js;
  protected final Wait<WebDriver> wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    js = (JavascriptExecutor) driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  protected WebElement findElement(By by) {
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    return driver.findElement(by);
  }

  protected List<WebElement> findElements(By by) {
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    return driver.findElements(by);
  }

  protected void click(By by) {
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    wait.until(ExpectedConditions.elementToBeClickable(by));
    try {
      findElement(by).click();
    } catch (StaleElementReferenceException e) {
      findElement(by).click();
    }
  }

  public void click(WebElement element) {
    element.click();
  }

  protected void sendKeys(By by, String value) {
    wait.until(ExpectedConditions.elementToBeClickable(by));
    findElement(by).sendKeys(value);
  }

  protected void select(By by, String value) {
    Select select = new Select(findElement(by));
    select.selectByValue(value);
  }

  protected static String getAmount(String str) {
    return str.replaceAll("[^0-9.]", "");
  }

  protected String getText(By by) {
    String text;
    try {
      text = findElement(by).getText();
    } catch (StaleElementReferenceException e) {
      text = findElement(by).getText();
    }
    return text;
  }

  protected void scrollIntoView(By by) {
    js.executeScript("arguments[0].scrollIntoView(true);", findElement(by));
  }
}
