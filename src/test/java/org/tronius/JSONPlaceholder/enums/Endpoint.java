package org.tronius.JSONPlaceholder.enums;

public enum Endpoint {
  API_POSTS("posts"),
  PATH_PARAM_API_POSTS("posts/{id}");

  public final String val;

  private Endpoint(String val) {
    this.val = val;
  }

  public String path() {
    return this.val;
  }
}
