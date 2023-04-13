package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class ItemsListPage extends UtilitiesMethods {

    private WebDriver driver;
    private WebElement assertItem;
    private WebElement salesAnchor;
    // private WebElement returnNotesAnchor;
    private WebElement salesInvoices;
    private WebElement priceLists;
    private WebElement stockAnchor;
    private WebElement items;
    private WebDriverWait wait;
    private WebElement newButton;
    private WebElement assertItemName;
    private JavascriptExecutor js;

    public ItemsListPage(WebDriver driver) {
        this.driver = driver;
    }

    /*******************************************************************************************************************************/
    public ItemPage createNewItem() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                (".clearfix span[module-name='Stock'] h5")));
        newButton = driver.findElement(By.id("appframe-btn-جديد"));
        js.executeScript("arguments[0].click();", newButton);
        // clickOnButton(newButton);
        return new ItemPage(driver);
    }

    /******************************************************************************************************************************/
    public SalesInvoicesListPage openSalesInvoicesListPage() {
        wait = new WebDriverWait(driver, ofSeconds(10));
        js = (JavascriptExecutor) driver;
        salesAnchor = driver.findElement(By.id("module-anchor-Selling"));
        js.executeScript("arguments[0].click();", salesAnchor);
        //clickOnButton(salesAnchor);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar-selling-invoice")));
        salesInvoices = driver.findElement(By.id("sidebar-selling-invoice"));
        js.executeScript("arguments[0].click();", salesInvoices);
        //clickOnButton(salesInvoices);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//h5[contains(text(),'قائمة فاتورة مبيعات')]")));
        return new SalesInvoicesListPage(driver);
    }

    /* public String getItemNameAfterSaving() {
         js = (JavascriptExecutor) driver;
         WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
         js.executeScript("window.scrollBy(0,500)");
      //   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                // ("(//div[contains(@class,'form-column doclist-col fix-ellipsis pull-left col-xs-4-5')])[2]")));
         //assertItemName = driver.findElement(By.xpath
         // ("(//div[contains(@class,'form-column doclist-col fix-ellipsis pull-left col-xs-4-5')])[2]"));
         //  System.out.println(assertItemName.getText());
         // return assertItemName.getText();
     }*/

    /********************************************************************************************************************************/
    public String getItemNameAfterSaving(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        assertItemName = driver.findElement(By.xpath
                ("(//div[@class='form-column doclist-col fix-ellipsis pull-left col-xs-2'])[5]/span"));
        System.out.println(assertItemName.getText());
        return assertItemName.getText();
    }

    /********************************************************************************************************************************/
    public PriceListPage openPriceListPage() {
        wait = new WebDriverWait(driver, ofSeconds(20));
        salesAnchor = driver.findElement(By.id("module-anchor-Selling"));
        clickOnButton(salesAnchor);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar-selling-price-list")));
        priceLists = driver.findElement(By.id("sidebar-selling-price-list"));
        clickOnButton(priceLists);
        return new PriceListPage(driver);
    }
}


