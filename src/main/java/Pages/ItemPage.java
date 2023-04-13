package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class ItemPage extends UtilitiesMethods {

    String selectedWarehouseName = "مستودع البضاعة المكتملة - dorgh";
    private WebDriver driver;
    private WebElement itemGroupField;
    private WebElement selectedGroup;
    private WebElement itemCode;
    private WebElement listIcon;
    private WebElement itemEnglishName;
    private WebElement saveButton;
    private WebElement assertItemName;
    private WebElement valuationMethodField;
    private WebElement selectedValuationMethodField;
    private WebElement defaultWarehouseField;
    private WebElement selectedWarehouse;
    private JavascriptExecutor js;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************************************************************************************************************/
    public ItemsListPage createAndSaveNewItem(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        itemGroupField = driver.findElement(By.xpath
                ("(//input[contains(@class,'input-with-feedback form-control ui-autocomplete-input')])[1]"));
        clickOnButton(itemGroupField);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(@class,'ui-corner-all')])[2]")));
        selectedGroup = driver.findElement(By.xpath
                ("(//a[contains(@class,'ui-corner-all')])[2]"));
        clickOnButton(selectedGroup);
        itemCode = driver.findElement(By.xpath
                ("(//input[contains(@class,'col-md-12 input-with-feedback form-control')])[6]"));
        itemEnglishName = driver.findElement(By.xpath
                ("(//input[contains(@class,'col-md-12 input-with-feedback form-control')])[7]"));
        saveButton = driver.findElement(By.xpath
                ("( //div[contains(@class,'btn-group form-group pull-left toolbar-btn-group form-column')])[2]"));
        enterDataToInputField(itemCode, itemName);
        defaultWarehouseField = driver.findElement(By.xpath
                ("(//input[contains(@class,'input-with-feedback form-control ui-autocomplete-input')])[4]"));
        clickOnButton(defaultWarehouseField);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//span[contains(text(),'مستودع البضاعة المكتملة - dorgh')]")));
        selectedWarehouse = driver.findElement(By.xpath("//span[contains(text(),'مستودع البضاعة المكتملة - dorgh')]"));
        clickOnButton(selectedWarehouse);
        valuationMethodField = driver.findElement(By.cssSelector
                ("div[title='طريقة التقييم'] .btn.dropdown-toggle.bs-placeholder.btn-block.btn-default .filter-option.pull-left"));
        clickOnButton(valuationMethodField);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                (".dropdown-menu.open.show .dropdown-menu.inner.scroll-styler li[data-original-index='3']")));
        selectedValuationMethodField = driver.findElement(By.cssSelector
                (".dropdown-menu.open.show .dropdown-menu.inner.scroll-styler li[data-original-index='3']"));
        clickOnButton(selectedValuationMethodField);
        js.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(4000);
        clickOnButton(saveButton);
        //js.executeScript("arguments[0].click();", saveButton);
        assertItemName = driver.findElement(By.xpath
                ("(//h5[contains(@class,'title-text pull-left')])[2]"));
        wait.until(ExpectedConditions.textToBePresentInElement(assertItemName, itemName));
        listIcon = driver.findElement(By.xpath
                ("(//i[contains(@class,'pull-left icon-shipping-delivery-box-1-ol')])[2]"));
        clickOnButton(listIcon);
        js.executeScript("window.scrollBy(0,200)");
        return new ItemsListPage(driver);
    }

    public String getItemNameAfterSaving() {
        js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        js.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//div[contains(@class,'form-column doclist-col fix-ellipsis pull-left col-xs-4-5')])[2]/a")));
        assertItemName = driver.findElement(By.xpath
                ("(//div[contains(@class,'form-column doclist-col fix-ellipsis pull-left col-xs-4-5')])[2]/a"));
        System.out.println(assertItemName.getText());
        return assertItemName.getText();
    }
}
