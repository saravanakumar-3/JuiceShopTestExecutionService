package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.juiceshop.test.executionservice.model.User;
import com.juiceshop.test.executionservice.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageStepDef extends BaseStepDef {
  @Autowired LoginPage loginPage;

  @Then("User should be navigated to Login page")
  public void userShouldBeNavigatedToLoginPage() {
    assertThat(loginPage.isLoginBtnIsDisplayed(), is(true));
  }

  @And("User should be able to login with credentials registered previously")
  public void userShouldBeAbleToLoginWithCredentialsRegisteredPreviously() {
    User user = testData.getUser();
    login(user.getEmail(), user.getPassword());
    assertThat(loginPage.isAccountBtnDisplayed(), is(true));
  }

  @When("User logins with below credentials")
  public void userLoginsWithBelowCredentials(Map<String, String> data) {
    login(data.get("Email"), data.get("Password"));
  }

  private void login(String email, String password) {
    loginPage.enterEmail(email);
    loginPage.enterPassword(password);
    loginPage.clickLoginBtn();
  }
}
