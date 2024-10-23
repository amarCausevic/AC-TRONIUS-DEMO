Feature: JSONPlaceholder provides us with /posts endpoint request we will execute test for GET, POST, PATCH, DELETE

  Scenario: As user I will send a GET request to fetch all posts available on JSONPlaceholder site
    Given user sends a GET request to fetch all posts
    When endpoint is reached, correct JSON schema is returned as defined in posts-schema.json
    Then validate fetch response data is correct
    And validate status code 200

  Scenario: As user I will send a POST request to create new post
    Given user sends a POST request to create new post
    When endpoint is reached, correct JSON schema is returned as defined in add-post-schema.json
    Then validate add response data is correct
    And validate status code 201

  Scenario: As user I will send a PATCH request to update new post
    Given user sends a PATCH request to update already created post
    When endpoint is reached, correct JSON schema is returned as defined in update-post-schema.json
    And validate status code 200

  Scenario: As user I will send a DELETE request to delete already created post
    Given user sends a DELETE request to remove already created post
    And validate status code 200