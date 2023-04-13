package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class ReportPage extends UtilitiesMethods {
    private WebDriver driver ;
    private WebDriverWait wait;
    private WebElement voucherNumber;
    private WebElement debitAmount;
    private WebElement invoiceTab;
    public ReportPage (WebDriver driver)
    {
        this.driver = driver;
    }
    public String getVoucherNumber ()
    {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//div[@class='slick-cell b2 f2']/a)[1]")));
        voucherNumber = driver.findElement(By.xpath("(//div[@class='slick-cell b2 f2']/a)[1]"));
        return voucherNumber.getText();
    }
    public String getdebitAmount ()
    {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//div[@class='slick-cell b2 f2']/a)[1]")));
        debitAmount = driver.findElement(By.xpath("(//div[@class='slick-cell b4 f4']/div)[3]"));
        return debitAmount.getText();

    }
    public SalesInvoicePage clickOnInvoiceTab()
    {
        invoiceTab = driver.findElement(By.xpath("//*[@id='sortable']/li[6]/div/a[1]"));
        clickOnButton(invoiceTab);
        return new SalesInvoicePage(driver);
    }

}
