package org.tronius.Helpers;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class NavigationAO {

  public void addChromeOptions() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized", "--start-incognito", "--no-default-browser-check",
        "--search-engine-choice-country");
    Configuration.browserCapabilities = options;
  }

  public void openPage(String url) {
    this.addChromeOptions();
    open(url);
    getWebDriver().manage().window().maximize();
  }
}
