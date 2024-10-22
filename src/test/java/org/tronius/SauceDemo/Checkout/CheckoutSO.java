package org.tronius.SauceDemo.Checkout;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class CheckoutSO {

  public final SelenideElement inputFirstName = $(byXpath("//input[@data-test='firstName']"));
  public final SelenideElement inputLastName = $(byXpath("//input[@data-test='lastName']"));
  public final SelenideElement inputPostalCode = $(byXpath("//input[@data-test='postalCode']"));
  public final SelenideElement buttonContinue = $(byXpath("//input[@data-test='continue']"));
  public final SelenideElement buttonFinish = $(byXpath("//button[@data-test='finish']"));
  public final SelenideElement buttonBackToDashboard = $(
      byXpath("//button[@data-test='back-to-products']"));
  public final SelenideElement paymentLabel = $(byXpath("//div[@data-test='payment-info-value']"));
  public final SelenideElement shippingLabel = $(
      byXpath("//div[@data-test='shipping-info-value']"));
  public final SelenideElement subtotalLabel = $(byXpath("//div[@data-test='subtotal-label']"));
  public final SelenideElement taxLabel = $(byXpath("//div[@data-test='tax-label']"));
  public final SelenideElement totalLabel = $(byXpath("//div[@data-test='total-label']"));
  public final SelenideElement completeHeader = $(byXpath("//h2[@data-test='complete-header']"));
  public final SelenideElement completeText = $(byXpath("//div[@data-test='complete-text']"));
}
