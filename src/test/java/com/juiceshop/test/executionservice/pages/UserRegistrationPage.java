package com.juiceshop.test.executionservice.pages;

import java.util.List;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.By.*;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class UserRegistrationPage extends CommonPage {
  public UserRegistrationPage(WebDriver driver) {
    super(driver);
  }

  public By email = By.id("emailControl");
  public By password = By.id("passwordControl");
  public By repeatPassword = By.id("repeatPasswordControl");
  public By showPasswordAdviceBtn = By.xpath("//span[@class='mat-slide-toggle-bar']");
  public By securityQuestionSelectBtn =
      By.xpath("//div[@class='security-container']/mat-form-field[1]/div/div[1]");
  public By securityQuestionOptions = By.xpath("//mat-option");
  public By securityAnswer = By.id("securityAnswerControl");
  public By registerBtn = By.xpath("//button[@id='registerButton']/span[1]");
  public By errors = By.tagName("mat-error");

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
    click(element);
  }

  public void toggleShowPasswordAdvice() {
    click(showPasswordAdviceBtn);
  }

  @SneakyThrows
  public void clickRegisterBtn() {
    click(registerBtn);
  }
}
