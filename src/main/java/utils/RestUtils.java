package utils;

import config.TroniusConfig;
import config.factory.ConfigFactory;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RestUtils extends RestAssured {

  public static final TroniusConfig CONFIG = ConfigFactory.troniusConfig();
  private static final Logger logger = LogManager.getLogger(RestUtils.class);

  private static RequestSpecBuilder builder() {
    return new RequestSpecBuilder();
  }

  public static RequestSpecification buildRequestBody(HashMap<String, ?> pathParams,
      HashMap<String, String> headers, Object bodyDTO) {
    return builder().setBaseUri(CONFIG.jsonPlaceholderBaseUri())
        .addPathParams(pathParams)
        .addHeaders(headers)
        .setContentType(ContentType.JSON)
        .setBody(bodyDTO)
        .build();
  }

  public static RequestSpecification buildRequestEmptyBody(HashMap<String, ?> pathParams,
      HashMap<String, String> headers) {
    return builder().setBaseUri(CONFIG.jsonPlaceholderBaseUri())
        .addPathParams(pathParams)
        .addHeaders(headers)
        .setContentType(ContentType.JSON)
        .build();
  }

  public static ValidatableResponse assertStatusCode(Response response, int code) {
    int statusCode = response.getStatusCode();

    try {
      logger.info("Validation of response status was SUCCESS! Status code was: {}", statusCode);

      return response.then().assertThat().statusCode(code);
    } catch (AssertionError assertionError) {
      logger.info("Validation of response status was FAILED! Status code was: {}", statusCode);

      throw new RuntimeException(assertionError);
    }
  }

  public static JsonPath extractResponseAsJSON(Response response) {
    return response.then().extract().body().jsonPath();
  }

  public static String extractResponseAsString(Response response) {
    return response.then().extract().response().body().asString();
  }

  public static HashMap<String, String> emptyHashMap() {
    return new HashMap<>();
  }

  public static Object emptyObject() {
    return new Object();
  }

  public void validateResponseDataSchema(Response response, String schemaPath) {
    File schemaFile = new File(schemaPath);

    response.then().assertThat()
        .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
  }
}
