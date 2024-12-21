package com.juiceshop.test.executionservice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class AddressCreatePage extends BasePage {
  public AddressCreatePage(WebDriver driver) {
    super(driver);
  }

  protected final By addNewAddressHeader = By.xpath("//h1[text()='Add New Address']");
  protected final By country = By.xpath("//input[contains(@data-placeholder, 'country')]");
  protected final By name = By.xpath("//input[contains(@data-placeholder, 'name')]");
  protected final By mobile = By.xpath("//input[contains(@data-placeholder, 'mobile')]");
  protected final By zip = By.xpath("//input[contains(@data-placeholder, 'ZIP')]");
  protected final By address = By.xpath("//textarea[contains(@data-placeholder, 'address')]");
  protected final By city = By.xpath("//input[contains(@data-placeholder, 'city')]");
  protected final By state = By.xpath("//input[contains(@data-placeholder, 'state')]");
  protected final By submitBtn = By.id("submitButton");

  public boolean isAddNewAddressHeaderDisplayed() {
    return findElement(addNewAddressHeader).isDisplayed();
  }

  public void enterCountry(String value) {
    sendKeys(country, value);
  }

  public void enterName(String value) {
    sendKeys(name, value);
  }

  public void enterMobile(String value) {
    sendKeys(mobile, value);
  }

  public void enterZip(String value) {
    sendKeys(zip, value);
  }

  public void enterAddress(String value) {
    sendKeys(address, value);
  }

  public void enterCity(String value) {
    sendKeys(city, value);
  }

  public void enterState(String value) {
    sendKeys(state, value);
  }

  public void clickSubmitBtn() {
    click(submitBtn);
  }
}
