package org.tronius.JSONPlaceholder;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.tronius.Enums.CommonString;
import org.tronius.Enums.NumberEnum;
import org.tronius.JSONPlaceholder.data.PostsData;
import org.tronius.JSONPlaceholder.enums.Endpoint;
import org.tronius.JSONPlaceholder.model.PostDTO;
import org.tronius.JSONPlaceholder.model.PostsDTO;
import utils.RestUtils;
import utils.StringUtils;

public class ApiDemoAO extends RestUtils {

  private static final StringUtils stringUtils = new StringUtils();
  private static Response response = null;
  private static PostDTO newPostDTO;
  private static HashMap<String, Integer> pathParam = new HashMap<String, Integer>();

  public static Response get() {
    response = RestAssured.given()
        .spec(buildRequestEmptyBody(emptyHashMap(), emptyHashMap())).log().all()
        .when()
        .log().all()
        .request(Method.GET, Endpoint.API_POSTS.val);

    return response;
  }

  public static Response post() {
    response = RestAssured.given()
        .spec(buildRequestBody(emptyHashMap(), emptyHashMap(), PostsData.addRequestPostDTO()))
        .log().all()
        .when()
        .log().all()
        .request(Method.POST, Endpoint.API_POSTS.val);

    return response;
  }

  public static Response patch() {
    pathParam.put("id", newPostDTO.getId());

    response = RestAssured.given()
        .spec(buildRequestBody(pathParam, emptyHashMap(),
            PostsData.updateRequestPostDTO(newPostDTO)))
        .log().all()
        .when()
        .log().all()
        .request(Method.PATCH, Endpoint.PATH_PARAM_API_POSTS.val);

    return response;
  }

  public static Response delete() {
    pathParam.put("id", newPostDTO.getId());

    response = RestAssured.given()
        .spec(buildRequestEmptyBody(pathParam, emptyHashMap()))
        .log().all()
        .when()
        .log().all()
        .request(Method.DELETE, Endpoint.PATH_PARAM_API_POSTS.val);

    return response;
  }

  private PostsDTO deserializePostsDTO(Response response) {
    if (response != null) {
      JsonPath body = extractResponseAsJSON(response);

      return body.getObject("", PostsDTO.class);
    }

    return null;
  }

  private PostDTO deserializePostDTO(Response response) {
    if (response != null) {
      JsonPath body = extractResponseAsJSON(response);

      return body.getObject("", PostDTO.class);
    }

    return null;
  }

  public void validateGETResponseDataSchema() {
    validateResponseDataSchema(response, CONFIG.schemaPosts());
  }

  public void validatePOSTResponseDataSchema() {
    validateResponseDataSchema(response, CONFIG.addPostSchema());
  }

  public void validatePATCHResponseDataSchema() {
    validateResponseDataSchema(response, CONFIG.updatePostSchema());
  }

  public void validateResponseMappedData() {
    PostsDTO postsDTO = deserializePostsDTO(response);
    PostDTO postDTO = postsDTO.getPosts().stream().findFirst().get();

    Assertions.assertEquals(postDTO.getTitle(), CommonString.POSTS_TITLE.val);
    Assertions.assertEquals(stringUtils.removeBreakLine(postDTO.getBody()),
        CommonString.POSTS_BODY.val);
  }

  public void validateAddResponseMappedData() {
    PostDTO postDTO = deserializePostDTO(response);
    newPostDTO = postDTO;

    Assertions.assertEquals(postDTO.getTitle(), CommonString.ADD_POST_TITLE.val);
    Assertions.assertEquals(postDTO.getBody(), CommonString.ADD_POST_BODY.val);
    Assertions.assertEquals(postDTO.getUserId(), NumberEnum.POST_DEFAULT_USER.val);
  }

  public void validateStatusCode(int statusCode) {
    assertStatusCode(response, statusCode);
  }
}
