package utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

public class StorageUtils {

  public void setItem(String propertyName, String propertyValue) {
    JavascriptExecutor script = (JavascriptExecutor) WebDriverRunner.getWebDriver();
    script.executeScript("sessionStorage.setItem(arguments[0],arguments[1])", propertyName,
        propertyValue);
  }

  public String getItem(String propertyName) {
    JavascriptExecutor script = (JavascriptExecutor) WebDriverRunner.getWebDriver();

    return (String) script.executeScript(
        String.format("return window.sessionStorage.getItem('%s');", propertyName));
  }
}
