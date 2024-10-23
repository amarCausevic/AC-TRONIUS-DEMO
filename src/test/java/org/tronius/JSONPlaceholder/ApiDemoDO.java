package org.tronius.JSONPlaceholder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiDemoDO {

  private final ApiDemoAO apiDemoAO = new ApiDemoAO();

  @Given("user sends a GET request to fetch all posts")
  public void fetchAllPosts() {
    apiDemoAO.get();
  }

  @Given("user sends a POST request to create new post")
  public void addPost() {
    apiDemoAO.post();
  }

  @Given("user sends a PATCH request to update already created post")
  public void updatePost() {
    apiDemoAO.patch();
  }

  @Given("user sends a DELETE request to remove already created post")
  public void deletePost() {
    apiDemoAO.delete();
  }

  @Then("validate fetch response data is correct")
  public void validateFetchMappedData() {
    apiDemoAO.validateResponseMappedData();
  }

  @Then("validate add response data is correct")
  public void validateAddMappedData() {
    apiDemoAO.validateAddResponseMappedData();
  }

  @When("endpoint is reached, correct JSON schema is returned as defined in posts-schema.json")
  public void validateResponseSchemaIsSameAsDefined() {
    apiDemoAO.validateGETResponseDataSchema();
  }

  @When("endpoint is reached, correct JSON schema is returned as defined in add-post-schema.json")
  public void validateAddResponseSchemaIsSameAsDefined() {
    apiDemoAO.validatePOSTResponseDataSchema();
  }

  @And("validate status code {int}")
  public void validateStatusCode(int expectedCode) {
    apiDemoAO.validateStatusCode(expectedCode);
  }

  @When("endpoint is reached, correct JSON schema is returned as defined in update-post-schema.json")
  public void validatePatchResponseSchemaIsSameAsDefined() {
    apiDemoAO.validatePATCHResponseDataSchema();
  }
}
