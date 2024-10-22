package org.tronius.SauceDemo.Checkout;

import com.codeborne.selenide.Condition;
import config.TroniusConfig;
import config.factory.ConfigFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.tronius.Enums.CommonString;
import org.tronius.Enums.NumberEnum;
import org.tronius.Enums.PropertyName;
import org.tronius.SauceDemo.Cart.CartSO;
import org.tronius.SauceDemo.Dashboard.DashboardSO;
import utils.ElementUtils;
import utils.NumberUtils;
import utils.StorageUtils;
import utils.WaitUtils;

public class CheckoutAO {

  private final CartSO cartSO = new CartSO();
  private final CheckoutSO checkoutSO = new CheckoutSO();
  private final DashboardSO dashboardSO = new DashboardSO();
  private final WaitUtils waitUtils = new WaitUtils();
  private final ElementUtils elementUtils = new ElementUtils();
  private final StorageUtils storageUtils = new StorageUtils();
  private final NumberUtils numberUtils = new NumberUtils();
  private final TroniusConfig CONFIG = ConfigFactory.troniusConfig();

  public void verifyConfirmationOrder() {
    checkoutSO.buttonFinish.click();
    Assertions.assertEquals(elementUtils.getText(checkoutSO.completeHeader),
        CommonString.CONFIRMATION_HEADER.val);
    Assertions.assertEquals(elementUtils.getText(checkoutSO.completeText),
        CommonString.CONFIRMATION_TEXT.val);
  }

  public void returnToDashboard() {
    checkoutSO.buttonBackToDashboard.shouldBe(Condition.visible).click();
    dashboardSO.inventoryList.get(NumberEnum.DEFAULT_INDEX.val).shouldBe(Condition.visible);
  }

  public void verifyUserLandsOnPage() {
    cartSO.buttonCheckout.shouldBe(Condition.visible).click();
    waitUtils.waitForElement(cartSO.title);
    Assertions.assertEquals(elementUtils.getText(cartSO.title), CommonString.CHECKOUT_TITLE.val);
  }

  public void setCustomerInformation() {
    checkoutSO.inputFirstName.shouldBe(Condition.visible).setValue(CONFIG.sauceCustomerName());
    checkoutSO.inputLastName.shouldBe(Condition.visible).setValue(CONFIG.sauceCustomerLastName());
    checkoutSO.inputPostalCode.shouldBe(Condition.visible)
        .setValue(CONFIG.sauceCustomerPostalCode());
  }

  public void verifyUserLandsOnOverviewPage() throws ParseException {
    checkoutSO.buttonContinue.click();
    assertCheckOverviewInformation();
  }

  public BigDecimal parsedPrice() throws ParseException {
    String price = storageUtils.getItem(PropertyName.ITEM_PRICE.val);

    return numberUtils.parse(price, Locale.US);
  }

  public BigDecimal parsedTax() throws ParseException {
    BigDecimal tax = new BigDecimal("0.08").multiply(parsedPrice())
        .setScale(2,
            RoundingMode.HALF_UP);

    return tax;
  }

  public BigDecimal totalPrice() throws ParseException {
    return parsedPrice().add(parsedTax());
  }

  public void assertCheckOverviewInformation() throws ParseException {
    String subtotal = priceLabel(parsedPrice(), CommonString.ITEM_TOTAL.val);
    String tax = priceLabel(parsedTax(), CommonString.TAX.val);
    String totalPrice = priceLabel(totalPrice(), CommonString.TOTAL.val);

    Assertions.assertEquals(elementUtils.getText(checkoutSO.paymentLabel),
        CommonString.PAYMENT_SOURCE.val);
    Assertions.assertEquals(elementUtils.getText(checkoutSO.shippingLabel),
        CommonString.SHIPPING_SOURCE.val);
    Assertions.assertEquals(elementUtils.getText(checkoutSO.subtotalLabel), subtotal);
    Assertions.assertEquals(elementUtils.getText(checkoutSO.taxLabel), tax);
    Assertions.assertEquals(elementUtils.getText(checkoutSO.totalLabel), totalPrice);
  }

  public String priceLabel(BigDecimal parsedValue, String label) {
    return String.format(label,
        numberUtils.covertBigDecimalToCurrency(parsedValue.toString(), Locale.US));
  }
}
