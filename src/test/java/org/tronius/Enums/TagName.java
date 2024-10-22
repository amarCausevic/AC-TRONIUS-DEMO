package org.tronius.Enums;

public enum TagName {
  ANCHOR("a"),
  BUTTON("button");

  public final String val;

  private TagName(String val) {
    this.val = val;
  }

  public String path() {
    return this.val;
  }
}
