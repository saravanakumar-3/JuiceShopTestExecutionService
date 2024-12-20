package com.juiceshop.test.executionservice.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;

@Log4j2
public class CommonPage extends BasePage {
  public CommonPage(WebDriver driver) {
    super(driver);
  }

  @Value("${automation.url}")
  protected String url;

  protected By backToHomepage = new By.ByXPath("//button[@aria-label='Back to homepage']");
  protected By dismissCookieMessageBtn =
      new By.ByXPath("//a[@aria-label='dismiss cookie message']");
  protected By closeWelcomeBannerBtn =
      new By.ByXPath("//button[@aria-label='Close Welcome Banner']");
  protected By languageChangedInfoBar =
      new By.ByXPath("//span[text()='Language has been changed to English']");
  protected By registrationSuccessfullyInfoBar =
      new By.ByXPath("//span[text()='Registration completed successfully. You can now log in.']");
  protected By navbarAccount = new By.ById("navbarAccount");

  protected void launchPage(String url) {
    driver.get(url);
    log.info("Navigated to url: " + url);
    wait.until(ExpectedConditions.visibilityOfElementLocated(backToHomepage));
  }

  public void dismissCookieMessage() {
    click(dismissCookieMessageBtn);
  }

  public void closeWelcomeBanner() {
    click(closeWelcomeBannerBtn);
  }

  public void clickEmptySpace() {
    click(new By.ByTagName("html"));
  }

  public boolean isRegistrationSuccessfulInfoBarDisplayed() {
    return findElement(registrationSuccessfullyInfoBar).isDisplayed();
  }

  public boolean isNavbarAccountBtnDisplayed() {
    return findElement(navbarAccount).isDisplayed();
  }
}
