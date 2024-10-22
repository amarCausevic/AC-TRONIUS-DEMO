package org.tronius.SauceDemo.Login;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class LoginSO {

  public final SelenideElement inputPassword = $(byXpath("//input[@name='password']"));
  public final SelenideElement inputUsername = $(byXpath("//input[@name='user-name']"));
  public final SelenideElement buttonLogin = $(byXpath("//input[@name='login-button']"));

  public void clickLoginButton() {
    buttonLogin.should(Condition.visible).click();
  }
}
