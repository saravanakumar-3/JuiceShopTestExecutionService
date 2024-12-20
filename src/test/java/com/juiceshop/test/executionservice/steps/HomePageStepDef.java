package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import com.juiceshop.test.executionservice.pages.HomePage;
import io.cucumber.java.en.Given;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class HomePageStepDef {
  @Autowired
  HomePage homepage;

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
    maxElement.click();
    String itemsPerPageNumber = homepage.getItemsPerPageNumber();
    assertThat(itemsPerPageNumber, is(itemsPerPageSelected));
  }

  @Given("Home page should display all {int} items")
  public void homePageShouldDisplayAllItems(int maxNumberOfItemsExpected) {
    assertThat(homepage.getAllItemsDisplayed().size(), is(maxNumberOfItemsExpected));
  }

  @Given("User clicks the product no {int}")
  public void clickOnGivenProduct(int productNo) {
    homepage.getAllItemsDisplayed().get(productNo - 1).click();
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
  }
}
