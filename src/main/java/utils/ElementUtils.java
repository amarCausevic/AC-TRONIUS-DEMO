package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class ElementUtils {

  public String getTextByClass(SelenideElement element, String className) {
    return element.findElement(By.className(className)).getText();
  }

  public String getText(SelenideElement element) {
    return element.getText();
  }
}
