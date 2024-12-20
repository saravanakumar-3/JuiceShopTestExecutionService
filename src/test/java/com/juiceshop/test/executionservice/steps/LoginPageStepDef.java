package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.juiceshop.test.executionservice.config.TestData;
import com.juiceshop.test.executionservice.model.User;
import com.juiceshop.test.executionservice.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageStepDef {
  @Autowired LoginPage loginPage;
  @Autowired TestData testData;

  @Then("User should be navigated to Login page")
  public void userShouldBeNavigatedToLoginPage() {
    assertThat(loginPage.isLoginBtnIsDisplayed(), is(true));
  }

  @And("User should be able to login with credentials registered previously")
  public void userShouldBeAbleToLoginWithCredentialsRegisteredPreviously() {
    User user = testData.getUser();
    loginPage.enterEmail(user.getEmail());
    loginPage.enterPassword(user.getPassword());
    loginPage.clickLoginBtn();
    loginPage.isNavbarAccountBtnDisplayed();
  }
}
