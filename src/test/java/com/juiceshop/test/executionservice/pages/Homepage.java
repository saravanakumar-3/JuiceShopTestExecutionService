package com.juiceshop.test.executionservice.pages;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class Homepage extends BasePage {
  public Homepage(WebDriver driver) {
    super(driver);
  }

  @Value("${automation.url}")
  private String url;

  public By backToHomepage = new ByXPath("//button[@aria-label='Back to homepage']");
  public By itemsPerPageBtn = new ByXPath("//mat-select[@aria-label='Items per page:']");
  public By itemsPerPageNumber = new ByXPath("//mat-select[@aria-label='Items per page:']//span/span");
  public By itemsPerPageOptions = new ByTagName("mat-option");
  public By paginatorRange = new ByClassName("mat-paginator-range-label");
  public By allItems = new ByTagName("mat-grid-tile");
  public By dismissCookieMessageBtn = new ByXPath("//a[@aria-label='dismiss cookie message']");
  public By closeWelcomeBannerBtn = new ByXPath("//button[@aria-label='Close Welcome Banner']");

  public void launchApplication() {
    driver.get(url);
    log.info("Navigated to url: " + url);
    wait.until(ExpectedConditions.visibilityOfElementLocated(backToHomepage));
  }

  public void clickItemsPerPageBtn() {
    click(itemsPerPageBtn);
  }

  public String getItemsPerPageNumber() {
    return findElement(itemsPerPageNumber).getText();
  }

  public List<WebElement> getItemsPerPageOptions() {
    return findElements(itemsPerPageOptions);
  }

  public String getPaginatorRange() {
    return findElement(paginatorRange).getText();
  }

  public List<WebElement> getAllItemsDisplayed() {
    return findElements(allItems);
  }

  public void dismissCookieMessage() {
    click(dismissCookieMessageBtn);
  }

  public void closeWelcomeBanner() {
    click(closeWelcomeBannerBtn);
  }
}