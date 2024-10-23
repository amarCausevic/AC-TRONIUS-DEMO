package org.tronius.JSONPlaceholder.data;

import org.tronius.Enums.CommonString;
import org.tronius.Enums.NumberEnum;
import org.tronius.JSONPlaceholder.model.AddPostDTO;
import org.tronius.JSONPlaceholder.model.PostDTO;

public class PostsData {

  public static AddPostDTO addRequestPostDTO() {
    return new AddPostDTO(CommonString.ADD_POST_TITLE.val, CommonString.ADD_POST_BODY.val,
        NumberEnum.POST_DEFAULT_USER.val);
  }

  public static PostDTO updateRequestPostDTO(PostDTO postDTO) {
    return new PostDTO(postDTO.getUserId(), postDTO.getUserId(), CommonString.UPDATE_POST_TITLE.val,
        CommonString.UPDATE_POST_BODY.val);
  }
}
