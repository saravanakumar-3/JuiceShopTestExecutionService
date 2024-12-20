package com.juiceshop.test.executionservice.pages;

import java.util.List;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.By.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class UserRegistrationPage extends CommonPage {
  public UserRegistrationPage(WebDriver driver) {
    super(driver);
  }

  public By email = new ById("emailControl");
  public By password = new ById("passwordControl");
  public By repeatPassword = new ById("repeatPasswordControl");
  public By showPasswordAdviceBtn = new ByXPath("//span[@class='mat-slide-toggle-bar']");
  public By securityQuestionSelectBtn =
      new ByXPath("//div[@class='security-container']/mat-form-field[1]/div/div[1]");
  public By securityQuestionOptions = new ByXPath("//mat-option");
  public By securityAnswer = new ById("securityAnswerControl");
  public By registerBtn = new ByXPath("//button[@id='registerButton']/span[1]");
  public By errors = new ByTagName("mat-error");

  public void launchUserRegistrationPage() {
    launchPage(url + "/#/register");
  }

  public void enterEmail(String value) {
    sendKeys(email, value);
  }

  public void enterPassword(String value) {
    sendKeys(password, value);
  }

  public void enterRepeatPassword(String value) {
    sendKeys(repeatPassword, value);
  }

  public void clickSecurityQuestionSelection() {
    click(securityQuestionSelectBtn);
  }

  public void enterSecurityAnswer(String value) {
    sendKeys(securityAnswer, value);
  }

  public List<String> getErrorMessages() {
    return findElements(errors).stream().map(WebElement::getText).collect(Collectors.toList());
  }

  public void selectSecurityQuestion(String securityQuestion) {
    clickSecurityQuestionSelection();
    WebElement element =
        findElements(securityQuestionOptions).stream()
            .filter(e -> e.getText().contains(securityQuestion))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException(securityQuestion));
    element.click();
  }

  public void toggleShowPasswordAdvice() {
    click(showPasswordAdviceBtn);
  }

  @SneakyThrows
  public void clickRegisterBtn() {
    wait.until(
        ExpectedConditions.not(
            ExpectedConditions.visibilityOfElementLocated(languageChangedInfoBar)));
    click(registerBtn);
  }
}
