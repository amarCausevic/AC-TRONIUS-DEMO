package org.tronius.SauceDemo.Dashboard;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class DashboardSO {

  public final ElementsCollection inventoryList = $$(byXpath("//div[@class='inventory_item']"));
  public final SelenideElement itemDetailsName = $(
      byXpath("//div[@data-test='inventory-item-name']"));
  public final SelenideElement itemDetailsDesc = $(
      byXpath("//div[@data-test='inventory-item-desc']"));
  public final SelenideElement itemDetailsPrice = $(
      byXpath("//div[@data-test='inventory-item-price']"));
  public final SelenideElement buttonAddToCart = $(
      byXpath("//button[@data-test='add-to-cart']"));
}
