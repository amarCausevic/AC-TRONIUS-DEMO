package org.tronius.JSONPlaceholder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
