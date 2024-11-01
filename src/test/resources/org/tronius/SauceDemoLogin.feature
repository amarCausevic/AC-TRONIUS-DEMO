Feature: Login feature with adding one item to the cart, at the end user will proceed to checkout and finish up the purchase

  Scenario: As authenticated user I will login into https://www.saucedemo.com/ and proceed with checkout of one item and finish up the purchase
    Given as user I will login into sauce demo application and land on dashboard page
    When user click on random item label and confirms correct data is displayed in item details page
    Then user clicks on cart button and verifies that correct item has been added
    And user clicks on checkout button and fills up the checkout information
    And user verifies Payment Information and proceeds with order confirmation
    And user clicks on back home button and user lands on dashboard page