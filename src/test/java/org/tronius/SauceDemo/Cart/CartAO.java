package org.tronius.SauceDemo.Cart;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.tronius.Enums.CommonString;
import org.tronius.SauceDemo.Dashboard.DashboardAO;
import org.tronius.SauceDemo.Dashboard.DashboardSO;
import utils.ElementUtils;
import utils.WaitUtils;

public class CartAO {

  private final CartSO cartSO = new CartSO();
  private final DashboardAO dashboardAO = new DashboardAO();
  private final DashboardSO dashboardSO = new DashboardSO();
  private final WaitUtils waitUtils = new WaitUtils();
  private final ElementUtils elementUtils = new ElementUtils();

  public void clickShoppingCartButton() {
    cartSO.buttonShoppingCartLink.shouldBe(Condition.visible).click();
  }

  public void verifyUserLandsOnPage() {
    waitUtils.waitForElement(cartSO.title);
    waitUtils.waitForElement(cartSO.cartList);
    Assertions.assertEquals(elementUtils.getText(cartSO.title), CommonString.CART_TITLE.val);
  }

  public void assertCartDetailInformation() {
    dashboardAO.assertItemDetailsPage();
  }
}
