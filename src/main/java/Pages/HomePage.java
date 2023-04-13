package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class HomePage extends UtilitiesMethods {
    private WebDriver driver;
    private WebElement assertItem;
    private WebElement salesAnchor;
    private WebElement salesInvoices;
    private WebElement stockAnchor;
    private WebElement items;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************************************************************************************************************/
    public WebElement getWebElement() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        assertItem = driver.findElement(By.xpath
                ("//div[contains(@class ,'dashboard-header')]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[contains(@class ,'dashboard-header')]")));
        wait.until(ExpectedConditions.visibilityOf(assertItem));
        return assertItem;
    }
/***************************************************************************************************************************/
    public SalesInvoicesListPage openSalesInvoicesListPage() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        salesAnchor = driver.findElement(By.id("module-anchor-Selling"));
        js.executeScript("arguments[0].click();", salesAnchor);
       // clickOnButton(salesAnchor);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar-selling-invoice")));
        salesInvoices = driver.findElement(By.id("sidebar-selling-invoice"));
        js.executeScript("arguments[0].click();", salesInvoices);
        //clickOnButton(salesInvoices);
        return new SalesInvoicesListPage(driver);
    }

    /******************************************************************************************************************************/
    public ItemsListPage openItemsListPage() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("module-anchor-Stock")));
        stockAnchor = driver.findElement(By.id("module-anchor-Stock"));
        //wait.until(ExpectedConditions.visibilityOf(stockAnchor));
        js.executeScript("arguments[0].click();", stockAnchor);
        //clickOnButton(stockAnchor);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar-stock-item")));
        items = driver.findElement(By.id("sidebar-stock-item"));
        js.executeScript("arguments[0].click();", items);
        // clickOnButton(items);
        return new ItemsListPage(driver);
    }
}
