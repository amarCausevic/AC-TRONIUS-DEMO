package org.tronius.Enums;

public enum CommonString {
  CART_TITLE("Your Cart"),
  CHECKOUT_TITLE("Checkout: Your Information"),
  ITEM_TOTAL("Item total: %s"),
  TAX("Tax: %s"),
  TOTAL("Total: %s"),
  PAYMENT_SOURCE("SauceCard #31337"),
  SHIPPING_SOURCE("Free Pony Express Delivery!"),
  CONFIRMATION_HEADER("Thank you for your order!"),
  CONFIRMATION_TEXT(
      "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

  public final String val;

  private CommonString(String val) {
    this.val = val;
  }

  public String path() {
    return this.val;
  }
}
