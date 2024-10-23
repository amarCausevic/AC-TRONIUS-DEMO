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
  ADD_POST_TITLE("New test title"),
  ADD_POST_BODY("New test body"),
  UPDATE_POST_TITLE("Update test title"),
  UPDATE_POST_BODY("Update test body"),
  CONFIRMATION_TEXT(
      "Your order has been dispatched, and will arrive just as fast as the pony can get there!"),
  POSTS_TITLE("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"),
  POSTS_BODY(
      "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto");

  public final String val;

  private CommonString(String val) {
    this.val = val;
  }

  public String path() {
    return this.val;
  }
}
