package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import com.juiceshop.test.executionservice.model.Basket;
import com.juiceshop.test.executionservice.pages.AddressSelectPage;
import com.juiceshop.test.executionservice.pages.BasketPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class YourBasketStepDef extends BaseStepDef {
  @Autowired BasketPage basketPage;
  @Autowired AddressSelectPage addressSelectPage;

  @And("All items added are displayed in basket")
  public void allItemsAddedAreDisplayedInBasket() {
    Basket actBasket = basketPage.getBasket();
    compareBaskets(actBasket, testData.getBasket());
  }

  @And("Total price is updated when item quantity is increased or decreased or deleted")
  public void totalPriceIsUpdatedWhenItemQuantityIsIncreasedOrDecreasedOrDeleted() {
    Basket initialBasket = basketPage.getBasket();

    basketPage.increaseItemQuantity(1);
    basketPage.waitTillItemQuantityInRowIs(1, 2);
    initialBasket.getItems().get(0).addQuantity(1);

    basketPage.decreaseItemQuantity(2);

    basketPage.deleteItem(3);
    basketPage.waitNoOfRowIs(4);
    initialBasket.getItems().remove(2);

    initialBasket.setTotalPrice(calculateTotalPrice(initialBasket.getItems()));

    basketPage.waitTillTotalPriceIs(initialBasket.getTotalPrice());
    Basket finalBasket = basketPage.getBasket();
    compareBaskets(initialBasket, finalBasket);
  }

  private void compareBaskets(Basket actBasket, Basket expBasket) {
    assertThat(actBasket.getTotalPrice(), is(expBasket.getTotalPrice()));
    assertThat(actBasket.getItems(), contains(expBasket.getItems().toArray()));
  }

  @Then("User clicks on checkout and navigated to Select Address page")
  public void userClicksOnCheckoutAndNavigatedToSelectAddressPage() {
    basketPage.waitForInfoBarToDisappear();
    basketPage.clickCheckout();
    assertThat(addressSelectPage.isSelectAddressHeaderDisplayed(), is(true));
  }
}
