package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.juiceshop.test.executionservice.pages.DeliveryMethodPage;
import com.juiceshop.test.executionservice.pages.PaymentPage;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class DeliveryMethodStepDef extends BaseStepDef {
  @Autowired DeliveryMethodPage deliveryMethodPage;
  @Autowired PaymentPage paymentPage;

  @And("User click on continue after selecting delivery speed and navigated to payment page")
  public void userClickOnContinueAfterSelectingDeliverySpeedAndNavigatedToPaymentPage() {
    deliveryMethodPage.clickOneDayDeliveryBtn();
    deliveryMethodPage.clickContinueBtn();
    assertThat(paymentPage.isPaymentOptionsHeaderDisplayed(), is(true));
  }
}
