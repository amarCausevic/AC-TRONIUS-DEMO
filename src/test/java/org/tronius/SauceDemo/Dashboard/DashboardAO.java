package org.tronius.SauceDemo.Dashboard;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.tronius.Enums.Dashboard.DashboardClass;
import org.tronius.Enums.NumberEnum;
import org.tronius.Enums.PropertyName;
import org.tronius.Enums.TagName;
import utils.ElementUtils;
import utils.NumberUtils;
import utils.StorageUtils;

public class DashboardAO {

  private final DashboardSO dashboardSO = new DashboardSO();
  private final NumberUtils numberUtils = new NumberUtils();
  private final ElementUtils elementUtils = new ElementUtils();
  private final StorageUtils storageUtils = new StorageUtils();

  public void navigateToItemDetailsPage() {
    int index = 0;
    int inventoryListLength = (int) dashboardSO.inventoryList.stream().count();
    int randomItemIndex = numberUtils.getRandom(NumberEnum.DEFAULT_INDEX.val, inventoryListLength);

    for (SelenideElement item : dashboardSO.inventoryList) {
      if (index == randomItemIndex) {
        setStorageItemInformation(item);
        item.findElement(By.tagName(TagName.ANCHOR.val)).click();
      }

      index++;
    }
  }

  public void assertItemDetailsPage() {
    Assert.assertEquals(storageUtils.getItem(PropertyName.ITEM_NAME.val),
        elementUtils.getText(dashboardSO.itemDetailsName), "Asserting detail label value");
    Assert.assertEquals(storageUtils.getItem(PropertyName.ITEM_DESC.val),
        elementUtils.getText(dashboardSO.itemDetailsDesc), "Asserting detail description value");
    Assert.assertEquals(storageUtils.getItem(PropertyName.ITEM_PRICE.val),
        elementUtils.getText(dashboardSO.itemDetailsPrice), "Asserting detail price value");
  }

  public void setStorageItemInformation(SelenideElement item) {
    storageUtils.setItem(PropertyName.ITEM_NAME.val,
        elementUtils.getTextByClass(item, DashboardClass.NAME.name));
    storageUtils.setItem(PropertyName.ITEM_DESC.val,
        elementUtils.getTextByClass(item, DashboardClass.DESC.name));
    storageUtils.setItem(PropertyName.ITEM_PRICE.val,
        elementUtils.getTextByClass(item, DashboardClass.PRICE.name));
  }
}
