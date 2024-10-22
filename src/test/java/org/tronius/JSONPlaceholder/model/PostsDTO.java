package org.tronius.JSONPlaceholder.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PostsDTO {

  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  private List<PostDTO> posts;

  @JsonCreator
  public PostsDTO(List<PostDTO> post) {
    this.posts = post;
  }
}
