package com.juiceshop.test.executionservice.steps;

import com.github.javafaker.Address;
import com.juiceshop.test.executionservice.pages.AddressCreatePage;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressCreateStepDef extends BaseStepDef {
  @Autowired AddressCreatePage addressCreatePage;

  @And("User adds new address and clicks on submit")
  public void userAddsNewAddressAndClicksOnSubmit() {
    Address address = faker.address();
    addressCreatePage.enterCountry(address.country());
    addressCreatePage.enterName(address.firstName());
    addressCreatePage.enterMobile(faker.number().digits(10));
    addressCreatePage.enterZip(faker.number().digits(7));
    addressCreatePage.enterAddress(address.fullAddress());
    addressCreatePage.enterCity(address.city());
    addressCreatePage.enterState(address.state());
    addressCreatePage.clickSubmitBtn();
  }
}
