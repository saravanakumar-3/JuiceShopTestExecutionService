package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.juiceshop.test.executionservice.pages.*;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderSummaryStepDef extends BaseStepDef {
  @Autowired OrderSummaryPage orderSummaryPage;
  @Autowired OrderCompletionPage orderCompletionPage;

  @And("User click on 'Place your order and pay' and navigated to order completion page")
  public void userClickOnPlaceYourOrderAndPayAndNavigatedToOrderCompletionPage() {
    orderSummaryPage.clickPlaceYourOrderAndPayBtn();
    assertThat(orderCompletionPage.isThankYouForYOurPurchaseHeaderDisplayed(), is(true));
  }
}
