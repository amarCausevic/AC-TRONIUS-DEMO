package org.tronius.SauceDemo.Cart;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class CartSO {

  public final SelenideElement buttonAddToCart = $(byXpath("//button[@data-test='add-to-cart']"));
  public final SelenideElement title = $(byXpath("//span[@data-test='title']"));
  public final SelenideElement cartList = $(byXpath("//div[@data-test='cart-list']"));
  public final SelenideElement buttonShoppingCartLink = $(
      byXpath("//a[@data-test='shopping-cart-link']"));
  public final SelenideElement buttonCheckout = $(
      byXpath("//button[@data-test='checkout']"));
}
