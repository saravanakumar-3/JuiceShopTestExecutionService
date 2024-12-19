package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.juiceshop.test.executionservice.pages.Homepage;
import io.cucumber.java.en.Given;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class HomePageStepDef {
  @Autowired Homepage homepage;

  @Given("User navigates to Home page")
  public void navigateToHomePage() {
    homepage.launchApplication();
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

  @Given("Home page should display all items")
  public void homePageShouldDisplayAllItems() {
    String maxNumberOfItemsAvailable = homepage.getPaginatorRange().split(" ")[4];
    int itemsDisplayed = homepage.getAllItemsDisplayed().size();
    assertThat(String.valueOf(itemsDisplayed), is(maxNumberOfItemsAvailable));
  }
}
