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

  @When("endpoint is reached, correct JSON schema is returned as defined in posts-schema.json")
  public void validateResponseSchemaIsSameAsDefined() {
    apiDemoAO.validateResponseDataSchema();
  }

  @Then("validate PostsDTO response data is same as retrieved from PostsResponseBodyDTO")
  public void validateMappedData() {
    apiDemoAO.validateResponseMappedResponseData();
  }

  @And("validate status code {int} GET all posts")
  public void validateStatusCodeGETAllPosts(int arg0) {
  }
}
