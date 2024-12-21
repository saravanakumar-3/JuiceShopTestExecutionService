package com.juiceshop.test.executionservice.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class OrderSummaryPage extends BasePage {
  public OrderSummaryPage(WebDriver driver) {
    super(driver);
  }

  protected final By orderSummaryHeader = By.className("order-summary");
  protected final By placeYourOrderAndPayBtn = By.xpath("//button[@aria-label='Complete your purchase']");

  public boolean isOrderSummaryDisplayed() {
    return findElement(orderSummaryHeader).isDisplayed();
  }

  public void clickPlaceYourOrderAndPayBtn() {
    click(placeYourOrderAndPayBtn);
  }
}
