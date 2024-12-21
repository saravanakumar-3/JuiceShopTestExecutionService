package com.juiceshop.test.executionservice.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class OrderCompletionPage extends BasePage {
  public OrderCompletionPage(WebDriver driver) {
    super(driver);
  }

  protected final By thankYouForYOurPurchaseHeader =
      By.xpath("//h1[text()='Thank you for your purchase!']");

  public boolean isThankYouForYOurPurchaseHeaderDisplayed() {
    return findElement(thankYouForYOurPurchaseHeader).isDisplayed();
  }
}
