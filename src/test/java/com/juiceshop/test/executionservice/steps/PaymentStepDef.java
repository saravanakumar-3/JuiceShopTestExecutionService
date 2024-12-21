package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.juiceshop.test.executionservice.pages.*;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentStepDef extends BaseStepDef {
  @Autowired PaymentPage paymentPage;
  @Autowired OrderSummaryPage orderSummaryPage;

  @And("User click on continue after adding card details and navigated to order summary page")
  public void userClickOnContinueAfterAddingCardDetailsAndNavigatedToPaymentPage() {
    paymentPage.clickAddCreditOrDebitCardBtn();
    paymentPage.enterName(testData.getUser().getName());
    paymentPage.enterCardNumber(getRandomNumber(16));
    paymentPage.selectExpiryMonth("1");
    paymentPage.selectExpiryYear("2080");
    paymentPage.clickSubmitBtn();
    paymentPage.clickSelectCardRadioBtn();
    paymentPage.clickContinueBtn();
    assertThat(orderSummaryPage.isOrderSummaryDisplayed(), is(true));
  }
}
