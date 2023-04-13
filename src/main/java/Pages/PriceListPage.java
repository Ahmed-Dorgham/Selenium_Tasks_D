package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class PriceListPage extends UtilitiesMethods {
    private WebDriver driver;
    private WebElement Standard_Selling;
    private WebDriverWait wait;

    private JavascriptExecutor js;

    public PriceListPage(WebDriver driver) {
        this.driver = driver;
    }

    /*********************************************************************************************************************************/
    public PriceListDoc openStandard_SellingPage() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Standard Selling")));
        Standard_Selling = driver.findElement(By.id("Standard Selling"));
        clickOnButton(Standard_Selling);
        Thread.sleep(3000);
        return new PriceListDoc(driver);
    }
}
