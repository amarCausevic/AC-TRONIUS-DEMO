package org.tronius.SauceDemo.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.tronius.SauceDemo.Dashboard.DashboardAO;

public class LoginDO {

  LoginAO loginAO = new LoginAO();
  DashboardAO dashboardAO = new DashboardAO();

  @Given("as user I will login into sauce demo application and land on dashboard page")
  public void loginAndLandOnDashboard() {
    loginAO.loginAndLandOnDashboard();
  }

  @When("user click on random item label and confirms correct data is displayed in item details page")
  public void clickOnRandomItemAndVerifyItemDetails() {
    dashboardAO.navigateToItemDetailsPage();
    dashboardAO.assertItemDetailsPage();
  }

  @Then("user clicks on cart button and verifies that correct item has been added")
  public void navigateToCartAndVerifyData() {

  }

/*  @And("user clicks on checkout button and fills up the checkout information")
  public void userClicksOnCheckoutButtonAndFillsUpTheCheckoutInformation() {

  }

  @And("user verifies Payment Information")
  public void userVerifiesPaymentInformation() {

  }

  @And("user verifies Shipping Information")
  public void userVerifiesShippingInformation() {

  }

  @And("user verifies Price Total")
  public void userVerifiesPriceTotal() {

  }

  @And("user clicks on finish button and verifies confirmation message")
  public void userClicksOnFinishButtonAndVerifiesConfirmationMessage() {
  }

  @And("user clicks on back home user lands back on swag lab dashboard")
  public void userClicksOnBackHomeUserLandsBackOnSwagLabDashboard() {
  }*/
}
