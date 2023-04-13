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
import java.util.List;

import static java.time.Duration.ofSeconds;

public class SalesInvoicePage extends UtilitiesMethods {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement updateStockCheckbox;
    private WebElement addNewRowButton;
    private List<WebElement> itemsList;
    private WebElement ul;
    private WebElement closeIcon;
    private WebElement itemField;
    private WebElement saveAndSubmitButton;
    private WebElement invoiceID;
    private WebElement invoiceIDName;
    String invoiceIDNameString;
    private WebElement acceptSubmit;
    private WebElement salesListIcon;
    private WebElement xx;
    private WebElement span;
    private WebElement basicPrice;
    private WebElement basicPricee;
    private WebElement seriesNumberField;
    private WebElement clientNameField;
    private WebElement showAccount;
    private WebElement INV;
    //private WebElement closeIcon;
    private WebElement terriority;
    private WebElement totalAmount;
    private WebElement yesButton;
    private WebElement clearCashElement;
    private WebElement settingIcon;

    private WebElement returnNoteButton;
    private WebElement x;
    private JavascriptExecutor js;

    public SalesInvoicePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUpdateStockCheckBoxElement() throws InterruptedException {
        wait = new WebDriverWait(driver, ofSeconds(20));
        js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"page-Form/Sales Invoice\"]/div/div[1]/div/div[1]/span/h5")));

        //js.executeScript("window.scrollBy(0,800)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'مع تحديث المخزون')]")));
        updateStockCheckbox = driver.findElement(By.xpath("//input[@data-fieldname='update_stock']"));
        return updateStockCheckbox;
    }

    public void createSalesInvoiceForCreatedItemAfterPriceList(String itemName) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        js.executeScript("window.scrollBy(0,1000)");

        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@id='tab_1']/div[11]/div[2]/div/form/div[2]/div/div/div[2]/div[2]/a")));
        addNewRowButton = driver.findElement(By.xpath("//*[@id='tab_1']/div[11]/div[2]/div/form/div[2]/div/div/div[2]/div[2]/a"));
        clickOnButton(addNewRowButton);
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@id='tab_1']/div[11]/div[2]/div/form/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div/div/div[2]/div[1]/div/input")));
        itemField = driver.findElement
                (By.xpath("//*[@id='tab_1']/div[11]/div[2]/div/form/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div/div/div[2]/div[1]/div/input"));
        enterDataToInputField(itemField, itemName);
        // wait.until(ExpectedConditions.
        xx = driver.findElement(By.xpath("//*[@id=\"tab_1\"]/div[15]/div/div[2]/div/form/div[2]/div[1]"));
        clickOnButton(xx);
        //   presenceOfElementLocated(By.xpath("//*[@id='tab_1']/div[11]/div[2]/div/form/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div/div/div[2]/div[1]/div/input")));
        basicPrice = driver.findElement(By.xpath("//*[@id='tab_1']/div[11]/div[2]/div/form/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div/div/div[6]/div[1]/input"));
        //clickOnButton(basicPrice);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.
                        xpath("//*[@id='tab_1']/div[11]/div[2]/div/form/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div/div/div[6]/div[1]/input"),
                "ر.س 100.00"));

    }

    /******************************************************************************************************************************/
    public void createSalesInvoiceAfterCreateItem(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[4]")));
        seriesNumberField = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[6]"));
        js.executeScript("arguments[0].click();", seriesNumberField);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INV')])[1]")));
        INV = driver.findElement(By.xpath
                ("(//span[contains(text(),'INV')])[1]"));
        clickOnButton(INV);
        //  js.executeScript("arguments[0].click();", INV);
        clientNameField = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        enterDataToInputField(clientNameField, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@title='إقليم']/div[1]/div/input"));
        clickOnButton(terriority);
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,800)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(text(),'+ إضافة صف جديد')])[10]")));
        addNewRowButton = driver.findElement(By.xpath
                ("(//a[contains(text(),'+ إضافة صف جديد')])[10]"));
        //js.executeScript("arguments[0].click();", addNewRowButton);
        clickOnButton(addNewRowButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@title='رمز الصنف']/div[1]/div/input")));
        itemField = driver.findElement(By.xpath
                ("//div[@title='رمز الصنف']/div[1]/div/input"));
        enterDataToInputField(itemField, itemName);
        basicPrice = driver.findElement(By.xpath
                ("//div[@title='export_rate']/div[1]/input"));
        clickOnButton(basicPrice);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@title='export_amount']/div[2]/div"), "ر.س 0.00"));
        js.executeScript("arguments[0].value='100';", basicPrice);
    }
    /***************************************************************************************************************************************/
    public void createSalesInvoice(String itemName) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));
        seriesNumberField = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", seriesNumberField);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INV')])[1]")));
        INV = driver.findElement(By.xpath
                ("(//span[contains(text(),'INV')])[1]"));
        clickOnButton(INV);
        //  js.executeScript("arguments[0].click();", INV);
        clientNameField = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        enterDataToInputField(clientNameField, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@title='إقليم']/div[1]/div/input"));
        clickOnButton(terriority);
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,800)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(text(),'+ إضافة صف جديد')])[1]")));
        addNewRowButton = driver.findElement(By.xpath
                ("(//a[contains(text(),'+ إضافة صف جديد')])[1]"));
        //js.executeScript("arguments[0].click();", addNewRowButton);
        clickOnButton(addNewRowButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@title='رمز الصنف']/div[1]/div/input")));
        itemField = driver.findElement(By.xpath
                ("//div[@title='رمز الصنف']/div[1]/div/input"));
        enterDataToInputField(itemField, itemName);
        basicPrice = driver.findElement(By.xpath
                ("//div[@title='export_rate']/div[1]/input"));
        clickOnButton(basicPrice);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@title='export_amount']/div[2]/div"), "ر.س 0.00"));
        js.executeScript("arguments[0].value='100';", basicPrice);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(4000);
       // clickOnButton(basicPrice);

        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath
                        ("(//a[contains(text(),'×')])[6]")));
        xx = driver.findElement(By.xpath
                ("(//a[contains(text(),'×')])[6]"));
      //  clickOnButton(xx);
        js.executeScript("arguments[0].click();", xx);
        js.executeScript("window.scrollBy(0,800)");
       // clickOnButton(basicPrice);
        basicPricee = driver.findElement(By.xpath
                ("//div[@data-fieldname='export_rate']/div[1]"));
        js.executeScript("arguments[0].click();", basicPricee);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@title='export_rate']/div[1]/input")));
        basicPrice = driver.findElement(By.xpath
                ("//div[@title='export_rate']/div[1]/input"));
        clickOnButton(basicPrice);
        //js.executeScript("arguments[0].click();", basicPrice);
        js.executeScript("arguments[0].value='100';", basicPrice);
        js.executeScript("arguments[0].click();", basicPrice);
        Thread.sleep(2000);
       robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(4000);
     //  x = driver.findElement(By.xpath("(//div[@class='dropdown']/a)[4]"));
     // clickOnButton(x);
        //clickOnButton(basicPrice);
       // js.executeScript("arguments[0].value='1';", x);
       //Thread.sleep(2000);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@title='export_amount']/div[2]/div"), "ر.س 100.00"));
    }
    /*****************************************************************************************************************************/
    public void createSalesInvoiceForCreatedIteemAfterPriceList(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[4]")));
        seriesNumberField = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[7]"));
        js.executeScript("arguments[0].click();", seriesNumberField);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INV')])[1]")));
        INV = driver.findElement(By.xpath
                ("(//span[contains(text(),'INV')])[1]"));
        clickOnButton(INV);
        //  js.executeScript("arguments[0].click();", INV);
        clientNameField = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        enterDataToInputField(clientNameField, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@title='إقليم']/div[1]/div/input"));
        clickOnButton(terriority);
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,800)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(text(),'+ إضافة صف جديد')])[12]")));
        addNewRowButton = driver.findElement(By.xpath
                ("(//a[contains(text(),'+ إضافة صف جديد')])[12]"));
        //js.executeScript("arguments[0].click();", addNewRowButton);
        clickOnButton(addNewRowButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@title='رمز الصنف']/div[1]/div/input")));
        itemField = driver.findElement(By.xpath
                ("//div[@title='رمز الصنف']/div[1]/div/input"));
        enterDataToInputField(itemField, itemName);
        basicPrice = driver.findElement(By.xpath
                ("//div[@title='export_rate']/div[1]/input"));
        clickOnButton(basicPrice);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@title='export_amount']/div[2]/div"), "ر.س 100.00"));
       // js.executeScript("arguments[0].value='100';", basicPrice);
    }

    public void addCreatedItemAfterPricelist() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("(//a[contains(@class,'grid-add-row btn btn-primary')])[1]")));
        addNewRowButton = driver.findElement(By.xpath("(//a[contains(@class,'grid-add-row btn btn-primary')])[1]"));
        clickOnButton(addNewRowButton);
        // Thread.sleep(3000);
       /* wait.until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector
                        ("ul[class='ui-autocomplete ui-front scroll-styler" +
                                " ui-menu ui-widget ui-widget-content ui-corner-all']  li.ui-menu-item > a")));*/

      /*  item_1 = driver.findElement
                (By.cssSelector("ul[class='ui-autocomplete ui-front scroll-styler" +
                        " ui-menu ui-widget ui-widget-content ui-corner-all']  li.ui-menu-item > a"));*/
      /*  wait.until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector
                        ("ul[class='ui-autocomplete ui-front scroll-stylerui-menu ui-widget ui-widget-content ui-corner-all']  li.ui-menu-item > a")));*/
       /* item_1 = driver.findElement
                (By.cssSelector("ul[class='ui-autocomplete ui-front scroll-styler" +
                        " ui-menu ui-widget ui-widget-content ui-corner-all']  li.ui-menu-item > a"));*/
        //clickOnButton(item_1);

        // x = driver.findElement(By.xpath("//input[contains(@data-fieldname,'item_code')]"));
        //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@data-fieldname,'item_code')]")));
        //  js.executeScript("arguments[0].click();", x);

        //clickOnButton(x);
        //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@data-fieldname,'item_code')]")));
        //  Thread.sleep(1000);
      /*   enterDataToInputField(x,"899x");
        Thread.sleep(2000);
        js.executeScript("arguments[0].value='123';", x);
        Thread.sleep(2000);*/
        //clickOnButton(item_1);
      /*  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.
                        xpath("(//div[contains(@class,'control-value like-disabled-input grid-overflow-ellipsis')])[6]"),
                "ر.س 100.00"));*/
        // js.executeScript("document.getElementByXpath('(//ul[contains(@class,'ui-autocomplete ui-front scroll-styler ui-menu ui-widget ui-widget-content ui-corner-all')])[55]').setAttribute('style', 'display: block; top: 1062px; left: 936px; width: 201px;')");


        ul = driver.findElement(By.
                xpath("(//ul[contains(@class,'ui-autocomplete ui-front scroll-styler ui-menu ui-widget ui-widget-content ui-corner-all')])[55]"));
        js.executeScript("arguments[0].setAttribute('style', 'display: block; top: 1062px; left: 936px; width: 201px;')", ul);
        //itemsList = ul.findElements(By.tagName("li"));
        //itemsList = ul.findElements(By.xpath("//li[contains(@class,'ui-menu-item')]"));
        //  System.out.println(itemsList.size());
        //Thread.sleep(6000);
        wait.until(ExpectedConditions.attributeToBe(By.
                        xpath("(//ul[contains(@class,'ui-autocomplete ui-front scroll-styler ui-menu ui-widget ui-widget-content ui-corner-all')])[55]"),
                "style", "display: block; top: 1062px; left: 936px; width: 201px;"));

        Thread.sleep(3000);
        //  driver.manage().timeouts().implicitlyWait(ofSeconds(30));
        //itemsList = ul.findElements(By.cssSelector("li[class='ui-menu-item'] > a > span[style='font-weight: bold;']"));
        itemsList = ul.findElements(By.xpath("//li[contains(@class,'ui-menu-item')] "));
        System.out.println(itemsList.size());
        // Thread.sleep(3000);
        // itemsList = ul.findElements(By.className("ui-menu-item"));
        for (int i = 0; i < itemsList.size(); i++) {
            span = itemsList.get(i).findElement(By.cssSelector("li[class='ui-menu-item'] > a > span[style='font-weight: bold;']"));

            if (span.getText().equalsIgnoreCase("111100011")) {
                clickOnButton(span);
                break;
            } /*else {
                System.out.println("this item not existed in list ");
            }*/
            // System.out.println(span.getText());
            //System.out.println(itemsList.size());
       /* itemsList = ul.findElements(By.tagName("a"));
        System.out.println(itemsList.size());
        itemsList = ul.findElements(By.className("ui-menu-item"));
        System.out.println(itemsList.size());
        itemsList = ul.findElements(By.tagName("span"));
        System.out.println(itemsList.size());*/
            //System.out.println(itemsList.get(0).getText());

            // }
        }

        //System.out.println(span.getText());
        //   System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
    }

    public void unCheckUpdateStockCheckBox() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-200)");
        updateStockCheckbox = driver.findElement(By.xpath("//input[@data-fieldname='update_stock']"));
        clickOnButton(updateStockCheckbox);

    }

    public WebElement getUnCheckUpdateStockCheckBoxElement() {
        return updateStockCheckbox;
    }

    /**************************************j nkl mnklnnnwr
     * kmdsk m    m kmn kjkkm kmk      n  nnewmsnfmn **************************************************************************************/
    public void closeWindowAfterSubmitting() {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath
                        ("(//a[contains(text(),'×')])[7]")));
        closeIcon = driver.findElement(By.xpath
                ("(//a[contains(text(),'×')])[7]"));
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
    public void closeWindowAfterSubmittingg() {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath
                        ("(//a[contains(text(),'×')])[7]")));
        closeIcon = driver.findElement(By.xpath
                ("(//a[contains(text(),'×')])[7]"));
        clickOnButton(closeIcon);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@class='status-bar pull-left']/span/i")));

        invoiceID = driver.findElement(By.xpath
                ("(//span[@module-name='Accounts']/h5)[2]"));
        invoiceIDNameString = invoiceID.getText();
        System.out.println(invoiceID.getText());
        salesListIcon = driver.findElement(By.xpath
                ("(//i[@doctype-name='Sales Invoice'])[2]"));
        clickOnButton(salesListIcon);
        // return new SalesInvoicesListPage(driver);
        //js.executeScript("arguments[0].click();", salesListIcon);
    }
    public ReportPage openReportPage ()
    {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-عرض حساب فرعي']")));
        showAccount = driver.findElement(By.xpath("//button[@id='appframe-btn-عرض حساب فرعي']"));
        clickOnButton(showAccount);
        return new ReportPage( driver);
    }
    public ReturnNotePage createReturnNote ()
    {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-إنشاء مذكرة إرجاع']")));
        returnNoteButton = driver.findElement(By.xpath("//button[@id='appframe-btn-إنشاء مذكرة إرجاع']"));
        clickOnButton(returnNoteButton);
        return new ReturnNotePage (driver);
    }

    /************************************************************************************************************************************/
    public String getInvoiceIDName() throws InterruptedException {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//div[@class= 'clearfix']/span/h5)[6]")));
       // Thread.sleep(5000);
        invoiceIDName = driver.findElement(By.xpath("(//div[@class= 'clearfix']/span/h5)[6]"));
        return invoiceIDName.getText();
    }
    public String getInvoiceIDNamee() throws InterruptedException {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//div[@class= 'clearfix']/span/h5)[4]")));
       Thread.sleep(5000);
        invoiceIDName = driver.findElement(By.xpath("(//div[@class= 'clearfix']/span/h5)[4]"));
        return invoiceIDName.getText();
    }
    public String getTotalAmount() throws InterruptedException {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//*[@id=\"tab_1\"]/div[15]/div/div[2]/div/form/div[12]/div[2]/div[2]/div")));
       // Thread.sleep(5000);
        totalAmount = driver.findElement(By.xpath("//*[@id=\"tab_1\"]/div[15]/div/div[2]/div/form/div[12]/div[2]/div[2]/div"));
        return totalAmount.getText();
    }

    public void getAmountFieldElement() {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.
                        xpath("(//div[contains(@class,'control-value like-disabled-input grid-overflow-ellipsis')])[6]"),
                "ر.س 100.00"));
      /*  amountField = driver.findElement(By.
                xpath("(//div[contains(@class,'control-value like-disabled-input grid-overflow-ellipsis')])[6]"));
        return amountField;*/
    }
    /******************************************************************************************************************************/
    public void saveAndSubmitSalesInvoice() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class='btn toolbar-btn btn-title btn-inverse']")));
        saveAndSubmitButton = driver.findElement(By.xpath
                ("//button[@class='btn toolbar-btn btn-title btn-inverse']"));
        clickOnButton(saveAndSubmitButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']")));
        acceptSubmit = driver.findElement(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']"));
        clickOnButton(acceptSubmit);
    }
    public void clearCash() {
        wait = new WebDriverWait(driver, ofSeconds(20));
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
    public WebElement percentage () throws InterruptedException {
        Thread.sleep(4000);
        return driver.findElement(By.xpath("(//div[@class= 'progress-chart col-md-6']/h5)[1]"));
    }
}
