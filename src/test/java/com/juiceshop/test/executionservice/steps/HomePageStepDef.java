package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import com.juiceshop.test.executionservice.model.Item;
import com.juiceshop.test.executionservice.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class HomePageStepDef extends BaseStepDef {
  @Autowired HomePage homepage;

  @Given("User navigates to Home page")
  public void navigateToHomePage() {
    homepage.launchHomePage();
    homepage.dismissCookieMessage();
    homepage.closeWelcomeBanner();
  }

  @Given("User select maximum number of items per page")
  public void userSelectMaximumNumberOfItemsPerPage() {
    homepage.clickItemsPerPageBtn();
    List<WebElement> itemsPerPageOptions = homepage.getItemsPerPageOptions();
    WebElement maxElement = itemsPerPageOptions.get(itemsPerPageOptions.size() - 1);
    String itemsPerPageSelected = maxElement.getText();
    homepage.click(maxElement);
    String itemsPerPageNumber = homepage.getItemsPerPageNumber();
    assertThat(itemsPerPageNumber, is(itemsPerPageSelected));
    log.info("Number of items per page is set to " + itemsPerPageNumber);
  }

  @Given("Home page should display all {int} items")
  public void homePageShouldDisplayAllItems(int maxNumberOfItemsExpected) {
    assertThat(homepage.getAllItems().size(), is(maxNumberOfItemsExpected));
    log.info(maxNumberOfItemsExpected + " items are displayed Home Page");
  }

  @Given("User clicks the product no {int}")
  public void clickOnGivenProduct(int productNo) {
    homepage.clickOnItem(productNo);
    log.info("Clicked on product no " + productNo);
  }

  @Given("Product popup should be displayed")
  public void verifyThatProductPopupDisplayed() {
    assertThat(homepage.isItemPopupDisplayed(), is(true));
  }

  @Given("User expands the review section")
  public void expandsTheReviewSection() {
    homepage.expandReviewSectionInProductPopup();
  }

  @Given("Reviews should be displayed")
  public void verifyTheNoOfReviews() {
    assertThat(homepage.getAllReviews().size(), greaterThan(0));
    log.info("Reviews are getting displayed in Product popup");
  }

  @Then("User add items to Basket and item count reflected correctly")
  public void userAddItemsToBasketAndItemCountReflectedCorrectly() {
    List<Item> items = testData.getBasket().getItems();
    List<String> allItemNames = homepage.getAllItemNames();
    List<BigDecimal> allItemPrices = homepage.getAllItemPrices();

    int noOfItemsToAdd = 3;
    int noOfItemsToAdded = 0;
    for (int i = 0; i < noOfItemsToAdd; i++) {
      if (homepage.isItemSoldOut(i + 1)) {
        ++noOfItemsToAdd;
        continue;
      }

      homepage.addItemNoToBasket(i + 1);
      ++noOfItemsToAdded;
      String itemName = allItemNames.get(i);
      assertThat(homepage.getInfoBarText(), is("Placed " + itemName + " into basket."));
      homepage.dismissInfoBar();
      homepage.waitTillNoOfItemsInTheBasketUpdatedTo(noOfItemsToAdded);
      log.info("Item '" + itemName + "' is added to Basket");

      Item item = new Item();
      item.setName(itemName);
      item.setPrice(allItemPrices.get(i));
      item.setQuantity(1);
      items.add(item);
    }
    testData.getBasket().setTotalPrice(calculateTotalPrice(items));
  }

  @And("User clicks on Your Basket")
  public void userClicksOnYourBasket() {
    homepage.clickYourBasketBtn();
  }
}
