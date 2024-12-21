package com.juiceshop.test.executionservice.steps;

import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class CommonStepDef extends BaseStepDef {
  @Autowired UserRegistrationPageStepDef userRegistrationPageStepDef;
  @Autowired LoginPageStepDef loginPageStepDef;

  @Given("User completes Registration and Login successfully")
  public void userCompletesRegistrationAndLoginSuccessfully() {
    userRegistrationPageStepDef.navigateToUserRegistrationPage();
    userRegistrationPageStepDef.userEntersValidInformationInAllFields();
    loginPageStepDef.userShouldBeAbleToLoginWithCredentialsRegisteredPreviously();
    log.info("User completes Registration and Login successfully");
  }
}
