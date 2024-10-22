package org.tronius.SauceDemo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.text.ParseException;
import org.tronius.SauceDemo.Cart.CartAO;
import org.tronius.SauceDemo.Checkout.CheckoutAO;
import org.tronius.SauceDemo.Dashboard.DashboardAO;
import org.tronius.SauceDemo.Login.LoginAO;

public class DemoDO {

  LoginAO loginAO = new LoginAO();
  DashboardAO dashboardAO = new DashboardAO();
  CheckoutAO checkoutAO = new CheckoutAO();
  CartAO cartAO = new CartAO();

  @Given("as user I will login into sauce demo application and land on dashboard page")
  public void loginAndLandOnDashboard() {
    loginAO.loginAndLandOnDashboard();
  }

  @When("user click on random item label and confirms correct data is displayed in item details page")
  public void clickOnRandomItemAndVerifyItemDetails() {
    dashboardAO.navigateToItemDetailsPage();
    dashboardAO.assertItemDetailsPage();
    dashboardAO.clickAddToCartButton();
  }

  @Then("user clicks on cart button and verifies that correct item has been added")
  public void navigateToCartAndVerifyData() {
    cartAO.clickShoppingCartButton();
    cartAO.verifyUserLandsOnPage();
    cartAO.assertCartDetailInformation();
  }

  @And("user clicks on checkout button and fills up the checkout information")
  public void userClicksOnCheckoutButtonAndFillsUpTheCheckoutInformation() {
    checkoutAO.verifyUserLandsOnPage();
    checkoutAO.setCustomerInformation();
  }


  @And("user verifies Payment Information and proceeds with order confirmation")
  public void userVerifiesPaymentInformation() throws ParseException {
    checkoutAO.verifyUserLandsOnOverviewPage();
    checkoutAO.verifyConfirmationOrder();
  }

  @And("user clicks on back home button and user lands on dashboard page")
  public void userClicksOnBackHomeButtonAndUserLandsOnDashboardPage() {
    checkoutAO.returnToDashboard();
  }
}
