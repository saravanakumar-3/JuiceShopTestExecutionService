package com.juiceshop.test.executionservice.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class PaymentPage extends BasePage {
  public PaymentPage(WebDriver driver) {
    super(driver);
  }

  protected final By paymentOptionsHeader = By.xpath("//h1[text()='My Payment Options']");
  protected final By addCreditOrDebitCardBtn =
      By.xpath("//mat-panel-description[contains(text(),'Add a credit or debit card')]");
  protected final By name = By.xpath("//mat-label[text()='Name']//preceding::input[1]");
  protected final By cardNumber =
      By.xpath("//mat-label[text()='Card Number']//preceding::input[1]");
  protected final By expiryMonth =
      By.xpath("//mat-label[text()='Expiry Month']//preceding::select");
  protected final By expiryYear =
      By.xpath("//mat-label[text()='Expiry Year']//preceding::select[1]");
  protected final By submitBtn = By.id("submitButton");
  protected final By selectCardRadioBtn = By.tagName("mat-radio-button");
  protected final By continueBtn = By.xpath("//button[@aria-label='Proceed to review']");

  public boolean isPaymentOptionsHeaderDisplayed() {
    return findElement(paymentOptionsHeader).isDisplayed();
  }

  public void clickAddCreditOrDebitCardBtn() {
    click(addCreditOrDebitCardBtn);
  }

  public void enterName(String value) {
    sendKeys(name, value);
  }

  public void enterCardNumber(String value) {
    sendKeys(cardNumber, value);
  }

  public void selectExpiryMonth(String value) {
    select(expiryMonth, value);
  }

  public void selectExpiryYear(String value) {
    select(expiryYear, value);
  }
  public void clickSubmitBtn() {
    click(submitBtn);
  }

  public void clickSelectCardRadioBtn() {
    click(selectCardRadioBtn);
  }

  public void clickContinueBtn() {
    click(continueBtn);
  }
}
