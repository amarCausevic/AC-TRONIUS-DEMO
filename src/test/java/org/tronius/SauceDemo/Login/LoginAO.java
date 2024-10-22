package org.tronius.SauceDemo.Login;

import config.TroniusConfig;
import config.factory.ConfigFactory;
import org.tronius.Helpers.NavigationAO;
import utils.WaitUtils;

public class LoginAO {

  private final TroniusConfig CONFIG = ConfigFactory.troniusConfig();
  private final NavigationAO navigationAO = new NavigationAO();
  private final WaitUtils waitUtils = new WaitUtils();
  private final LoginSO loginSO = new LoginSO();

  public void setupCredentials() {
    loginSO.inputUsername.setValue(CONFIG.sauceUsername());
    loginSO.inputPassword.setValue(CONFIG.saucePassword());
  }

  public void loginAndLandOnDashboard() {
    navigationAO.openPage(CONFIG.sauceBaseUri());
    waitUtils.waitForElement(loginSO.inputPassword);
    setupCredentials();
    loginSO.clickLoginButton();
  }
}
