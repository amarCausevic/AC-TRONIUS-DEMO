package org.tronius.Enums;

public enum PropertyName {
  ITEM_NAME("ITEM_NAME"),
  ITEM_DESC("ITEM_DESC"),
  ITEM_PRICE("ITEM_PRICE");

  public final String val;

  private PropertyName(String val) {
    this.val = val;
  }

  public String path() {
    return this.val;
  }
}
