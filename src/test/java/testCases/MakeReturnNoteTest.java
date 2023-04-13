package testCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class MakeReturnNoteTest extends TestBase {
    // private final String emailId = "Administrator";
    //  private final String password = "A@d3y2M6u6Nk";

    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private SalesInvoicesListPage salesInvoicesListPageObject;
    private SalesInvoicePage salesInvoicePageObject;
    private ReturnNotePage ReturnNotePageObject ;
    private ItemsListPage itemsListPageObject;
    private ItemPage itemPageObject;
    private PriceListDoc priceListDocObject;
    private PriceListPage priceListPageObject;
    private ReportPage ReportPageObject;
    private String InvoiceIDName;
    private String totalAmount;
    String priceListfilePath = System.getProperty("user.dir") + "\\ExcelSheets\\return_note.xlsx";

    @DataProvider(name = "testdata")
    public Object[][] readingData() throws IOException {
        return readingDataMethod(priceListfilePath, 3);
    }

    @Test(priority = 1, dataProvider = "testdata")

    public void createReturnNote(String emailId, String password, String itemName) throws InterruptedException, AWTException {
        loginPageObject = new LoginPage(driver);
        homePageObject = loginPageObject.loginWithValidData(emailId, password);
        Assert.assertTrue(homePageObject.getWebElement().isDisplayed());
        itemsListPageObject = homePageObject.openItemsListPage();
        itemPageObject = itemsListPageObject.createNewItem();
        itemPageObject.createAndSaveNewItem(itemName);
        priceListPageObject = itemsListPageObject.openPriceListPage();
        priceListDocObject = priceListPageObject.openStandard_SellingPage();
        salesInvoicesListPageObject = priceListDocObject.addingCreatedItemToPriceList(itemName);
        Assert.assertTrue(salesInvoicesListPageObject.getSalesInvoicesListElement().isDisplayed());
        salesInvoicePageObject = salesInvoicesListPageObject.openNewSalesInvoiceForCreatedItemAfterPriceList();
        salesInvoicePageObject.createSalesInvoiceForCreatedIteemAfterPriceList(itemName);
        totalAmount = salesInvoicePageObject.getTotalAmount();
        salesInvoicePageObject.saveAndSubmitSalesInvoice();
        salesInvoicePageObject.closeWindowAfterSubmitting();
        InvoiceIDName = salesInvoicePageObject.getInvoiceIDName();
        ReportPageObject = salesInvoicePageObject.openReportPage();
        Assert.assertEquals(ReportPageObject.getVoucherNumber(), InvoiceIDName);
        Assert.assertEquals(ReportPageObject.getdebitAmount(), totalAmount);
        salesInvoicePageObject =  ReportPageObject.clickOnInvoiceTab();
        ReturnNotePageObject =salesInvoicePageObject.createReturnNote();
        ReturnNotePageObject.enterDataToReturnNote();
        ReturnNotePageObject.saveAndSubmitRerurnNote();
        ReturnNotePageObject.closeWindowAfterSubmitting();
        ReturnNotePageObject.getreturnNoteIDName();
         salesInvoicePageObject = ReturnNotePageObject.returnToSalesInvoice();
         salesInvoicePageObject.clearCash();
        Assert.assertTrue(salesInvoicePageObject.percentage().getText().contains("100% "));

        // salesInvoicesListPageObject.getSalesInvoiceNameAfterSubmitting();
        // Assert.assertEquals(salesInvoicesListPageObject.getSalesInvoiceNameAfterSubmitting(), salesInvoicePageObject.getInvoiceIDName());
    }
    //(  @Test(priority = 2,)
   /* public void openItemsListPage() throws InterruptedException {
        itemsListPageObject = homePageObject.openItemsListPage();
        itemPageObject = itemsListPageObject.createNewItem();
    }
  //  @Test(priority = 3)
   public void createNewItem() throws InterruptedException {
        itemPageObject.createAndSaveNewItem(itemName);
    }
 //   @Test(priority = 4)
    public void openPriceListPage() throws InterruptedException {
        priceListPageObject = itemsListPageObject.openPriceListPage();
        priceListDocObject = priceListPageObject.openStandard_SellingPage();
        //priceListDocObject.addingCreatedItemToPriceList(itemName);
        // Assert.assertTrue(salesInvoicesListPageObject.getSalesInvoicesListElement().isDisplayed());
    }
  //  @Test(priority = 5 )
    public void openSalesInvoicesListPage() throws InterruptedException, AWTException {
        salesInvoicesListPageObject = priceListDocObject.addingCreatedItemToPriceList(itemName);
        Assert.assertTrue(salesInvoicesListPageObject.getSalesInvoicesListElement().isDisplayed());
    }
  //  @Test(priority = 6)
    public void makeSalesInvoicesForCreatedItem() throws InterruptedException {
        salesInvoicePageObject = salesInvoicesListPageObject.openNewSalesInvoiceForCreatedItemAfterPriceList();
        salesInvoicePageObject.createSalesInvoiceForCreatedIteemAfterPriceList(itemName);
        salesInvoicePageObject.saveAndSubmitSalesInvoice();
        salesInvoicesListPageObject = salesInvoicePageObject.closeWindowAfterSubmitting();
        salesInvoicesListPageObject.clearCash();
        salesInvoicesListPageObject.getSalesInvoiceNameAfterSubmitting();
        Assert.assertEquals(salesInvoicesListPageObject.getSalesInvoiceNameAfterSubmitting(), salesInvoicePageObject.getInvoiceIDName());
    }
    */
}