package org.tronius.JSONPlaceholder;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.tronius.Enums.CommonString;
import org.tronius.JSONPlaceholder.enums.Endpoint;
import org.tronius.JSONPlaceholder.model.PostDTO;
import org.tronius.JSONPlaceholder.model.PostsDTO;
import utils.RestUtils;
import utils.StringUtils;

public class ApiDemoAO extends RestUtils {

  private static Response response;
  private final StringUtils stringUtils = new StringUtils();

  public static Response get() {
    response = RestAssured.given()
        .spec(buildRequestEmptyBody(emptyHashMap(), emptyHashMap())).log().all()
        .when()
        .log().all()
        .request(Method.GET, Endpoint.API_POSTS.val);

    return response;
  }

  private PostsDTO deserializePostsDTO(Response response) {
    if (response != null) {
      JsonPath body = extractResponseAsJSON(response);

      return body.getObject("", PostsDTO.class);
    }

    return null;
  }

  public void validateResponseDataSchema() {
    File schema = new File(CONFIG.schemaPosts());

    response.then().assertThat()
        .body(JsonSchemaValidator.matchesJsonSchema(schema));
  }

  public void validateResponseMappedResponseData() {
    PostsDTO postsDTO = deserializePostsDTO(response);
    PostDTO postDTO = postsDTO.getPosts().stream().findFirst().get();

    Assertions.assertEquals(postDTO.getTitle(), CommonString.POSTS_TITLE.val);
    Assertions.assertEquals(stringUtils.removeBreakLine(postDTO.getBody()),
        CommonString.POSTS_BODY.val);
  }
}
