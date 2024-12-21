package com.juiceshop.test.executionservice.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DeliveryMethodPage extends BasePage {
  public DeliveryMethodPage(WebDriver driver) {
    super(driver);
  }

  protected final By deliveryAddressHeader = By.xpath("//h1[text()='Delivery Address']");
  protected final By oneDayDeliveryBtn =
      By.xpath("//mat-cell[contains(text(),'One Day Delivery')]");
  protected final By continueBtn =
      By.xpath("//button[@aria-label='Proceed to delivery method selection']");

  public boolean isDeliveryAddressHeaderDisplayed() {
    return findElement(deliveryAddressHeader).isDisplayed();
  }

  public void clickOneDayDeliveryBtn() {
    click(oneDayDeliveryBtn);
  }

  public void clickContinueBtn() {
    click(continueBtn);
  }
}
