package org.tronius.Enums;

public enum NumberEnum {
  DEFAULT_INDEX(1),
  ZERO_INDEX(0),
  POST_DEFAULT_USER(199);

  public final int val;

  private NumberEnum(int val) {
    this.val = val;
  }

  public int path() {
    return this.val;
  }
}
