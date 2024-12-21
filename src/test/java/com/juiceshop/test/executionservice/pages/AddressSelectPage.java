package com.juiceshop.test.executionservice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class AddressSelectPage extends BasePage {
  public AddressSelectPage(WebDriver driver) {
    super(driver);
  }

  protected final By selectAddressHeader = By.xpath("//h1[text()='Select an address']");
  protected final By selectAddressRadioBtn = By.tagName("mat-radio-button");
  protected final By continueBtn = By.xpath("//button[@aria-label='Proceed to payment selection']");
  protected final By addNewAddressBtn = By.xpath("//span[text()='Add New Address']");

  public boolean isSelectAddressHeaderDisplayed() {
    return findElement(selectAddressHeader).isDisplayed();
  }

  public void clickAddNewAddressBtn() {
    click(addNewAddressBtn);
  }

  public void clickSelectAddressRadioBtn() {
    click(selectAddressRadioBtn);
  }

  public void clickContinueBtn() {
    click(continueBtn);
  }
}
