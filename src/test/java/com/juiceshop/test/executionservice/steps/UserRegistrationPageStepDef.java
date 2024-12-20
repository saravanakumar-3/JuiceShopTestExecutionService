package com.juiceshop.test.executionservice.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import com.github.javafaker.Faker;
import com.juiceshop.test.executionservice.config.TestData;
import com.juiceshop.test.executionservice.model.User;
import com.juiceshop.test.executionservice.pages.UserRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class UserRegistrationPageStepDef {
  @Autowired UserRegistrationPage registrationPage;
  @Autowired TestData testData;

  @Given("User navigates to User Registration page")
  public void navigateToUserRegistrationPage() {
    registrationPage.launchUserRegistrationPage();
    registrationPage.dismissCookieMessage();
    registrationPage.closeWelcomeBanner();
  }

  @When("User leave all field empty with entering any input after clicking")
  public void userLeaveAllFieldEmptyWithEnteringAnyInputAfterClicking() {
    registrationPage.enterEmail("");
    registrationPage.enterPassword("");
    registrationPage.enterRepeatPassword("");
    registrationPage.clickSecurityQuestionSelection();
    registrationPage.enterSecurityAnswer("");
    registrationPage.clickEmptySpace();
  }

  @Then("Validation message should be displayed in all respective fields")
  public void validationMessageShouldBeDisplayedInAllRespectiveFields() {
    List<String> errorMessages = registrationPage.getErrorMessages();
    assertThat(errorMessages, hasItem("Please provide an email address."));
    assertThat(errorMessages, hasItem("Please provide a password."));
    assertThat(errorMessages, hasItem("Please repeat your password."));
    assertThat(errorMessages, hasItem("Please select a security question."));
    assertThat(errorMessages, hasItem("Please provide an answer to your security question."));
  }

  @And("User enters valid information in all fields and Registers")
  public void userEntersValidInformationInAllFields() {
    User user = getNewRandomUser();
    testData.setUser(user);
    registrationPage.enterEmail(user.getEmail());
    registrationPage.enterPassword(user.getPassword());
    registrationPage.enterRepeatPassword(user.getPassword());
    registrationPage.selectSecurityQuestion(user.getSecurityQuestion());
    registrationPage.enterSecurityAnswer(user.getSecurityAnswer());
    registrationPage.toggleShowPasswordAdvice();
    registrationPage.clickEmptySpace();
    registrationPage.clickRegisterBtn();
    registrationPage.isRegistrationSuccessfulInfoBarDisplayed();
  }

  private User getNewRandomUser() {
    Faker faker = new Faker();
    User user = new User();
    user.setEmail(faker.internet().emailAddress());
    user.setPassword(faker.internet().password());
    user.setSecurityQuestion("Your favorite book?");
    user.setSecurityAnswer(faker.book().title());
    return user;
  }
}
