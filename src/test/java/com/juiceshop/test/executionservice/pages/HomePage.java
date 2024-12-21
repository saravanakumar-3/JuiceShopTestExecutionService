package com.juiceshop.test.executionservice.pages;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
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

  public By itemsPerPageBtn = By.xpath("//mat-select[@aria-label='Items per page:']");
  public By itemsPerPageNumber = By.xpath("//mat-select[@aria-label='Items per page:']//span/span");
  public By itemsPerPageOptions = By.tagName("mat-option");
  public By allItems = By.tagName("mat-grid-tile");
  public By allItemNames = By.className("item-name");
  public By allItemPrices = By.className("item-price");
  public By allAddToBasketBtns = By.xpath("//button[@aria-label='Add to Basket']");
  public By itemPopup = By.tagName("mat-dialog-container");
  public By reviewSectionPanelContent = By.xpath("//mat-panel-title");
  public By allReviews = By.xpath("//div[@class='ng-star-inserted']/div");

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

  public List<WebElement> getAllItems() {
    return findElements(allItems);
  }

  public void clickOnItem(int itemNo) {
    click(getAllItems().get(itemNo - 1));
  }

  public List<String> getAllItemNames() {
    return findElements(allItemNames).stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  public List<BigDecimal> getAllItemPrices() {
    return findElements(allItemPrices).stream()
        .map(e -> new BigDecimal(getAmount(e.getText())))
        .collect(Collectors.toList());
  }

  public List<WebElement> getAllAddToBasketBtns() {
    return findElements(allAddToBasketBtns);
  }

  public void addItemNoToBasket(int itemNo) {
    click(getAllAddToBasketBtns().get(itemNo - 1));
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

  public void waitTillNoOfItemsInTheBasketUpdatedTo(int i) {
    wait.until(d -> getNoOfItemsInTheBasket() == i);
  }
}
