package com.juiceshop.test.executionservice.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.By.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class LoginPage extends CommonPage {
  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public By email = By.id("email");
  public By password = By.id("password");
  public By loginBtn = By.id("loginButton");

  public void launchUserLoginPage() {
    launchPage(url + "/#/login");
  }

  public void enterEmail(String value) {
    sendKeys(email, value);
  }

  public void enterPassword(String value) {
    sendKeys(password, value);
  }

  public boolean isLoginBtnIsDisplayed() {
    return findElement(loginBtn).isDisplayed();
  }

  public void clickLoginBtn() {
    click(loginBtn);
  }
}
