package org.tronius.JSONPlaceholder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {

  @JsonProperty("userId")
  private int userId;
  @JsonProperty("id")
  private int id;
  @JsonProperty("title")
  private String title;
  @JsonProperty("body")
  private String body;
}
