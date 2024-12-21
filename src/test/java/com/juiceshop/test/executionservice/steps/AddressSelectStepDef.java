package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.juiceshop.test.executionservice.pages.AddressCreatePage;
import com.juiceshop.test.executionservice.pages.AddressSelectPage;
import com.juiceshop.test.executionservice.pages.DeliveryMethodPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class AddressSelectStepDef extends BaseStepDef {
  @Autowired AddressSelectPage selectAddressPage;
  @Autowired AddressCreatePage addressCreatePage;
  @Autowired DeliveryMethodPage deliveryMethodPage;

  @And("User clicks on create new address and navigated to create address page")
  public void userClicksOnCreateNewAddressAndNavigatedToCreateAddressPage() {
    selectAddressPage.clickAddNewAddressBtn();
    assertThat(addressCreatePage.isAddNewAddressHeaderDisplayed(), is(true));
  }

  @Then("User click on continue after selecting address and navigated to delivery method page")
  public void userClickOnContinueAfterSelectingAddressAndNavigatedToDeliveryMethodPage() {
    selectAddressPage.clickSelectAddressRadioBtn();
    selectAddressPage.clickContinueBtn();
    assertThat(deliveryMethodPage.isDeliveryAddressHeaderDisplayed(), is(true));
  }
}
