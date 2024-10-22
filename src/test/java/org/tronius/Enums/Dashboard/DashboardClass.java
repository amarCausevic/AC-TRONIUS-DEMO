package org.tronius.Enums.Dashboard;

public enum DashboardClass {
  NAME("inventory_item_name"),
  DESC("inventory_item_desc"),
  PRICE("inventory_item_price"),
  DETAILS_NAME("inventory_details_name"),
  DETAILS_DESC("inventory_details_desc"),
  DETAILS_PRICE("inventory_details_price");

  public final String name;

  private DashboardClass(String name) {
    this.name = name;
  }

  public String path() {
    return this.name;
  }
}
