package com.juiceshop.test.executionservice.pages;

import com.juiceshop.test.executionservice.model.Basket;
import com.juiceshop.test.executionservice.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class BasketPage extends CommonPage {
  public BasketPage(WebDriver driver) {
    super(driver);
  }

  protected final By noOfRows = By.tagName("mat-row");
  protected final String itemNames = "//mat-row[${rowNumber}]/mat-cell[2]";
  protected final String itemQuantityDecreaseBtn = "//mat-row[${rowNumber}]/mat-cell[3]/button[1]";
  protected final String itemQuantity = "//mat-row[${rowNumber}]/mat-cell[3]/span";
  protected final String itemQuantityIncreaseBtn = "//mat-row[${rowNumber}]/mat-cell[3]/button[2]";
  protected final String itemPrice = "//mat-row[${rowNumber}]/mat-cell[4]";
  protected final String itemQuantityDeleteBtn = "//mat-row[${rowNumber}]/mat-cell[5]";
  protected final By totalPrice = By.id("price");
  protected final By checkout = By.xpath("//button[@id='checkoutButton']");

  public BigDecimal getTotalPrice() {
    String price = findElement(totalPrice).getText();
    price = getAmount(price);
    return new BigDecimal(price);
  }

  public Basket getBasket() {
    List<Item> items = new ArrayList<>();
    int rows = findElements(noOfRows).size();
    for (int i = 0; i < rows; i++) {
      items.add(getItem(i + 1));
    }
    Basket basket = new Basket();
    basket.setItems(items);
    basket.setTotalPrice(getTotalPrice());
    return basket;
  }

  public Item getItem(int row) {
    Item item = new Item();

    String name = updateRowNumber(itemNames, row);
    String text = getText(By.xpath(name));
    item.setName(text);

    String quantity = updateRowNumber(itemQuantity, row);
    text = getText(By.xpath(quantity));
    item.setQuantity(Integer.parseInt(text));

    String price = updateRowNumber(itemPrice, row);
    text = getText(By.xpath(price));
    item.setPrice(new BigDecimal(getAmount(text)));

    return item;
  }

  public void increaseItemQuantity(int i) {
    String path = updateRowNumber(itemQuantityIncreaseBtn, i);
    click(By.xpath(path));
  }

  public void decreaseItemQuantity(int i) {
    String path = updateRowNumber(itemQuantityDecreaseBtn, i);
    click(By.xpath(path));
  }

  public void deleteItem(int i) {
    String path = updateRowNumber(itemQuantityDeleteBtn, i);
    click(By.xpath(path));
  }

  private String updateRowNumber(String path, int i) {
    return path.replace("${rowNumber}", String.valueOf(i));
  }

  public void clickCheckout() {
    js.executeScript("arguments[0].scrollIntoView(true);", findElement(checkout));
    click(checkout);
  }

  public void waitTillItemQuantityInRowIs(int row, int expQuantity) {
    wait.until(d -> getItem(row).getQuantity() == expQuantity);
  }

  public void waitNoOfRowIs(int expRows) {
    wait.until(d -> findElements(noOfRows).size() == expRows);
  }

  public void waitTillTotalPriceIs(BigDecimal expTotalPrice) {
    wait.until(d -> getTotalPrice().equals(expTotalPrice));
  }
}
