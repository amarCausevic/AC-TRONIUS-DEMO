package utils;

import com.codeborne.selenide.WebDriverRunner;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

  public void waitForElement(WebElement waitForThisElement) {
    Duration duration = Duration.ofSeconds(30);

    WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), duration);
    wait.until(ExpectedConditions.elementToBeClickable(waitForThisElement));
  }
}
