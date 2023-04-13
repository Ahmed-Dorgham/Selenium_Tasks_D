package testCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddingItemAndMakeSalesInvoiceTest extends TestBase {
   // private final String emailId = "Administrator";
  //  private final String password = "A@d3y2M6u6Nk";
   // String itemName = "dsfffd";
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private SalesInvoicesListPage salesInvoicesListPageObject;
    private SalesInvoicePage salesInvoicePageObject;
    private ItemsListPage itemsListPageObject;
    private ItemPage itemPageObject;
    private String salesInvoicefilePath = System.getProperty("user.dir") + "\\ExcelSheets\\salesinvoice.xlsx";
    @DataProvider(name = "addingItemAndMakeSalesInvoice")
    public Object[][] readingData () throws IOException {
        return readingDataMethod(salesInvoicefilePath, 3);
    }
    @Test(priority = 1,dataProvider = "addingItemAndMakeSalesInvoice")

    public void addingItemAndMakeSalesInvoice(String emailId, String password, String itemName) throws InterruptedException {
        loginPageObject = new LoginPage(driver);
        homePageObject = loginPageObject.loginWithValidData(emailId, password);
        Assert.assertTrue(homePageObject.getWebElement().isDisplayed());
        itemsListPageObject = homePageObject.openItemsListPage();
        itemPageObject = itemsListPageObject.createNewItem();
        itemsListPageObject = itemPageObject.createAndSaveNewItem(itemName);
        Assert.assertEquals(itemsListPageObject.getItemNameAfterSaving(itemName), itemName);
        salesInvoicesListPageObject = itemsListPageObject.openSalesInvoicesListPage();
        Assert.assertTrue(salesInvoicesListPageObject.getSalesInvoicesListElement().isDisplayed());
        salesInvoicePageObject = salesInvoicesListPageObject.openNewSalesInvoiceForCreatedItemAfterItemList();
        salesInvoicePageObject.createSalesInvoiceAfterCreateItem(itemName);
        salesInvoicePageObject.saveAndSubmitSalesInvoice();
        String IDName = salesInvoicePageObject.getInvoiceIDNamee();
       salesInvoicePageObject.closeWindowAfterSubmittingg();
        salesInvoicesListPageObject.clearCash();
        salesInvoicesListPageObject.getSalesInvoiceNameAfterSubmitting();
        Assert.assertEquals(salesInvoicesListPageObject.getSalesInvoiceNameAfterSubmitting(), IDName);
    }

  //  @Test(priority = 2)
    public void openItemsListPage() {
        itemsListPageObject = homePageObject.openItemsListPage();
        itemPageObject = itemsListPageObject.createNewItem();
    }

   // @Test(priority = 3)
  /*  public void createAndSaveNewItem() throws InterruptedException {
        itemsListPageObject = itemPageObject.createAndSaveNewItem(itemName);
        Assert.assertEquals(itemsListPageObject.getItemNameAfterSaving(itemName), itemName);
    }

  //  @Test(priority = 4)
    public void openSalesInvoicesListPage() {
        salesInvoicesListPageObject = itemsListPageObject.openSalesInvoicesListPage();
        Assert.assertTrue(salesInvoicesListPageObject.getSalesInvoicesListElement().isDisplayed());
    }

   // @Test(priority = 5)

    public void makeSalesInvoicesForCreatedItem() throws InterruptedException {
        salesInvoicePageObject = salesInvoicesListPageObject.openNewSalesInvoiceForCreatedItemAfterItemList();
        salesInvoicePageObject.createSalesInvoiceAfterCreateItem(itemName);
        salesInvoicePageObject.saveAndSubmitSalesInvoice();
        salesInvoicesListPageObject = salesInvoicePageObject.closeWindowAfterSubmitting();
        salesInvoicesListPageObject.clearCash();
        salesInvoicesListPageObject.getSalesInvoiceNameAfterSubmitting();
        Assert.assertEquals(salesInvoicesListPageObject.getSalesInvoiceNameAfterSubmitting(), salesInvoicePageObject.getInvoiceIDName());
    }

   */
}
