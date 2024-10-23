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
public class AddPostDTO {

  @JsonProperty("title")
  private String title;
  @JsonProperty("body")
  private String body;
  @JsonProperty("userId")
  private int userId;
}
