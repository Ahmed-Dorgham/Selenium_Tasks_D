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

public class ReturnNotePage extends UtilitiesMethods {
    private WebDriver driver ;
    private WebDriverWait wait ;
    private JavascriptExecutor js ;
    private WebElement seriesNumberField;
    private WebElement saveAndSubmitButton;
    private WebElement acceptSubmit;
    private WebElement closeIcon;
    private WebElement returnNoteIDName;
    private WebElement RN;
    private WebElement salesInvoiceLink;
    public ReturnNotePage (WebDriver driver)
    {
        this.driver = driver ;
    }


    public void enterDataToReturnNote () throws InterruptedException {
        js =  (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(text(),'إختر')])[11]")));
        Thread.sleep(10000);
        seriesNumberField = driver.findElement(By.xpath("(//span[contains(text(),'إختر')])[11]"));
      //  clickOnButton(chooseSerial);
       // js.executeScript("arguments[0].click();", chooseSerial);
        js.executeScript("arguments[0].click();", seriesNumberField);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(text(),'RN')])")));
        RN = driver.findElement(By.xpath("(//span[contains(text(),'RN')])"));

       // clickOnButton(serial);
      //  js.executeScript("arguments[0].click();", serial);
        js.executeScript("arguments[0].click();", RN);
        Thread.sleep(3000);

    }
    public void saveAndSubmitRerurnNote() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        saveAndSubmitButton = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-حفظ و اعتماد']"));
      //  clickOnButton(saveAndSubmitButton);
        js.executeScript("arguments[0].click();", saveAndSubmitButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']")));
        acceptSubmit = driver.findElement(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']"));
    //    clickOnButton(acceptSubmit);
        js.executeScript("arguments[0].click();", acceptSubmit);
    }
    /*******************************************************************************************************************************/
    public void closeWindowAfterSubmitting() {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath
                        ("(//a[contains(text(),'×')])[10]")));
        closeIcon = driver.findElement(By.xpath
                ("(//a[contains(text(),'×')])[10]"));
        clickOnButton(closeIcon);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@class='status-bar pull-left']/span/i")));



       /* invoiceID = driver.findElement(By.xpath
                ("(//span[@module-name='Accounts']/h5)[2]"));
        invoiceIDName = invoiceID.getText();
        System.out.println(invoiceID.getText());
        salesListIcon = driver.findElement(By.xpath
                ("(//i[@doctype-name='Sales Invoice'])[2]"));
        clickOnButton(salesListIcon);*/
        // return new SalesInvoicesListPage(driver);
        //js.executeScript("arguments[0].click();", salesListIcon);
    }
    public SalesInvoicePage returnToSalesInvoice ()
    {
        salesInvoiceLink = driver.findElement(By.xpath("//*[@id='tab_1']/div[1]/div/div/form/div[3]/div[2]/a"));
        //    clickOnButton(salesInvoiceLink);
        js.executeScript("arguments[0].click();", salesInvoiceLink);
        return new SalesInvoicePage (driver);
    }
    public String getreturnNoteIDName () throws InterruptedException {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//div[@class= 'clearfix']/span/h5)[8]")));
        // Thread.sleep(5000);
        returnNoteIDName = driver.findElement(By.xpath("(//div[@class= 'clearfix']/span/h5)[8]"));
        System.out.println(returnNoteIDName.getText());
        return returnNoteIDName.getText();
    }

}
