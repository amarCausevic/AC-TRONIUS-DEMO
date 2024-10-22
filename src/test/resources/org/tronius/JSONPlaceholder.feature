Feature: JSONPlaceholder provides us with /posts endpoint request we will execute test for GET, POST, PATCH, DELETE

  @StatusCode200
  Scenario: As user I will send a GET request to fetch all posts available on JSONPlaceholder site
    Given user sends a GET request to fetch all posts
    When endpoint is reached, correct JSON schema is returned as defined in posts-schema.json
    Then validate PostsDTO response data is same as retrieved from PostsResponseBodyDTO
    And validate status code 200 GET all posts