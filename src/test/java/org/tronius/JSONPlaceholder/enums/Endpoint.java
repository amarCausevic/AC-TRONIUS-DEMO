package org.tronius.JSONPlaceholder.enums;

public enum Endpoint {
  API_POSTS("posts");

  public final String val;

  private Endpoint(String val) {
    this.val = val;
  }

  public String path() {
    return this.val;
  }
}
