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

  protected By backToHomepage = By.xpath("//button[@aria-label='Back to homepage']");
  protected By dismissCookieMessageBtn = By.xpath("//a[@aria-label='dismiss cookie message']");
  protected By closeWelcomeBannerBtn = By.xpath("//button[@aria-label='Close Welcome Banner']");
  protected By infoBar = By.xpath("//span[@class='mat-simple-snack-bar-content']");
  protected By navbarAccount = By.id("navbarAccount");
  protected By noOfItemsInBasket =
      By.xpath("//button[@aria-label='Show the shopping cart']/span/span[2]");
  protected By yourBasketBtn = By.xpath("//button[@aria-label='Show the shopping cart']");

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

  public String getInfoBarText() {
    return findElement(infoBar).getText();
  }

  public boolean isAccountBtnDisplayed() {
    return findElement(navbarAccount).isDisplayed();
  }

  public int getNoOfItemsInTheBasket() {
    return Integer.parseInt(findElement(noOfItemsInBasket).getText());
  }

  public void clickYourBasketBtn() {
    click(yourBasketBtn);
  }

  public void waitForInfoBarToDisappear() {
    wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(infoBar)));
  }
}
