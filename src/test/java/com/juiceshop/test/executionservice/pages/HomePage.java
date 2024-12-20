package com.juiceshop.test.executionservice.pages;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class HomePage extends CommonPage {
  public HomePage(WebDriver driver) {
    super(driver);
  }

  public By itemsPerPageBtn = new ByXPath("//mat-select[@aria-label='Items per page:']");
  public By itemsPerPageNumber =
      new ByXPath("//mat-select[@aria-label='Items per page:']//span/span");
  public By itemsPerPageOptions = new ByTagName("mat-option");
  public By paginatorRange = new ByClassName("mat-paginator-range-label");
  public By allItems = new ByTagName("mat-grid-tile");
  public By itemPopup = new ByTagName("mat-dialog-container");
  public By reviewSectionExpandBtn = new ByXPath("//mat-expansion-panel");
  public By reviewSectionPanelContent = new ByXPath("//mat-panel-title");
  public By allReviews = new ByXPath("//div[@class='ng-star-inserted']/div");

  public void launchHomePage() {
    launchPage(url);
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

  public boolean isItemPopupDisplayed() {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(itemPopup));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public void expandReviewSectionInProductPopup() {
    WebElement element = findElement(reviewSectionPanelContent);
    wait.until(d -> !element.getText().replaceAll("[^0-9]", "").isEmpty());
    click(reviewSectionPanelContent);
  }

  public List<WebElement> getAllReviews() {
    return findElements(allReviews);
  }
}
