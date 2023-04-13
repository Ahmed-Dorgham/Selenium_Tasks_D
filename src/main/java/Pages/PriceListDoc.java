package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.time.Duration.ofSeconds;

public class PriceListDoc extends UtilitiesMethods {
    //*[@id="first_demo_section_356777433"]/div[3]/div[2]/div/form/div/div/div[2]/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div/input
    String itemCodeFieldXPath = "//*[@id=\"first_demo_section_356777433\"]/div[3]/div[2]/div/form/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div/input";
    String itemPriceFieldXPath = "//*[@id=\"first_demo_section_356777433\"]/div[3]/div[2]/div/form/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/input";
    //*[@id="first_demo_section_356777433"]/div[3]/div[2]/div/form/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div/input
    private WebDriver driver;
    private WebElement addNewRow;
    private WebElement itemCodeField;
    private WebElement itemPrice;
    private WebElement itemPrices;
    private WebElement saveButton;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private WebElement salesInvoices;
    private WebElement closeIcon;
    private WebElement basicInformation;

    public PriceListDoc(WebDriver driver) {
        this.driver = driver;
    }

    /****************************************************************************************************************************************/
    public SalesInvoicesListPage addingCreatedItemToPriceList(String itemName) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        //js.executeScript("window.scrollBy(0,500)");
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("//a[@id='item_prices_section-tab-body']/span")));
        itemPrices = driver.findElement(By.xpath
                ("//a[@id='item_prices_section-tab-body']/span"));
        clickOnButton(itemPrices);

        js.executeScript("window.scrollBy(0,200)");
        //a[contains(text(),'+ إضافة صف جديد')]

        addNewRow = driver.findElement(By.xpath("( //a[contains(text(),'+ إضافة صف جديد')])[11]"));
        //   js.executeScript("arguments[0].click();", addNewRow);
        clickOnButton(addNewRow);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@data-fieldname='item_code'])[2]")));
        itemCodeField = driver.findElement(By.xpath("(//input[@data-fieldname='item_code'])[2]"));
        enterDataToInputField(itemCodeField, itemName);
        itemPrice = driver.findElement(By.xpath(" (//input[@data-fieldname='ref_rate'])"));
        clickOnButton(itemPrice);
        enterDataToInputField(itemPrice, "100");
        js.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(4000);
      /*  wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("( //button[@id='appframe-btn-حفظ'])[1]")));*/
        //  saveButton = driver.findElement(By.xpath("(//button[@id='appframe-btn-حفظ'])[1]"));

        //*[@id="page-Form/Price List"]/div/div[1]/div/div[4]/div[1]
        //  wait.until(ExpectedConditions.
        //        presenceOfElementLocated(By.xpath("//*[@id='page-Form/Price List']/div/div/div/div[4]/div/button")));
        //*[@id="page-Form/Price List"]/div/div[1]/div/div[4]/div[1]
     //   basicInformation = driver.findElement(By.xpath("//a[@id='first_demo_section_356777433-tab-body']/span"));
        // clickOnButton(basicInformation);
        //Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(4000);
        //Thread.sleep(4000);
        //   js.executeScript("arguments[0].click();", saveButton);
        //clickOnButton(saveButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header'])[4]/a")));

        closeIcon = driver.findElement(By.xpath("(//div[@class='modal-header'])[4]/a"));
        clickOnButton(closeIcon);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar-selling-invoice")));
        salesInvoices = driver.findElement(By.id("sidebar-selling-invoice"));
        clickOnButton(salesInvoices);
        // Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(text(),'قائمة فاتورة مبيعات')]")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='appframe-btn-جديد'])[3]")));
        return new SalesInvoicesListPage(driver);


    }
}
