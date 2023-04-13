package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class SalesInvoicesListPage extends UtilitiesMethods {
    private WebDriver driver;
    private WebElement assertItem;
    private WebDriverWait wait;
    private WebElement newButton;
    private WebElement clearCashElement;
    private WebElement settingIcon;
    private WebElement assertSalesInvoiceName;
    private WebElement yesButton;
    private JavascriptExecutor js;

    public SalesInvoicesListPage(WebDriver driver) {
        this.driver = driver;
    }
/***********************************************************************************************************************/
    public SalesInvoicePage openNewSalesInvoice() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='appframe-btn-جديد']")));
        newButton = driver.findElement(By.id("appframe-btn-جديد"));
        //clickOnButton(newButton);
        js.executeScript("arguments[0].click();", newButton);
        return new SalesInvoicePage(driver);
    }

    /******************************************************************************************************************************/
    public SalesInvoicePage openNewSalesInvoiceForCreatedItemAfterItemList() {
        wait = new WebDriverWait(driver, ofSeconds(20));
        js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//button[@id='appframe-btn-جديد'])[2]")));
        newButton = driver.findElement(By.xpath
                ("(//button[@id='appframe-btn-جديد'])[2]"));
        js.executeScript("arguments[0].click();", newButton);
        return new SalesInvoicePage(driver);
    }
/******************************************************************************************************************************/
    public SalesInvoicePage openNewSalesInvoiceForCreatedItemAfterPriceList() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='appframe-btn-جديد'])[3]")));
        newButton = driver.findElement(By.xpath("(//button[@id='appframe-btn-جديد'])[3]"));
        js.executeScript("arguments[0].click();", newButton);
        //clickOnButton(newButton);
        return new SalesInvoicePage(driver);
    }

    /*******************************************************************************************************************************/
    public WebElement getSalesInvoicesListElement() {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//h5[contains(text(),'قائمة فاتورة مبيعات')]")));
        assertItem = driver.findElement(By.xpath
                ("//h5[contains(text(),'قائمة فاتورة مبيعات')]"));
        return assertItem;
    }

    /*******************************************************************************************************************************/
    public void clearCash() {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//h5[contains(text(),'قائمة فاتورة مبيعات')]")));
        settingIcon = driver.findElement(By.xpath
                ("//i[@data-kooltip='إعداد']"));
        clickOnButton(settingIcon);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='clear-cach-icon']")));
        clearCashElement = driver.findElement(By.xpath
                ("//li[@id='clear-cach-icon']"));
        clickOnButton(clearCashElement);
        yesButton = driver.findElement(By.xpath
                ("//button[@class='btn btn-info btn-yes']"));
        clickOnButton(yesButton);
    }
    public String getSalesInvoiceNameAfterSubmitting() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
       Thread.sleep(9000);
        js.executeScript("window.scrollBy(0,800)");
        assertSalesInvoiceName = driver.findElement(By.xpath
                ("(//div[@class='form-column doclist-col fix-ellipsis pull-left col-xs-4'])[2]/a"));
        System.out.println(assertSalesInvoiceName.getText());
        return assertSalesInvoiceName.getText();
    }
}
