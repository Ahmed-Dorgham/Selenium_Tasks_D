package testCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SalesInvoicePage;
import Pages.SalesInvoicesListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class MakeSalesInvoiceTest extends TestBase {
    private final String emailId = "Administrator";
    private final String password = "A@d3y2M6u6Nk";
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private SalesInvoicesListPage salesInvoicesListPageObject;
    private SalesInvoicePage salesInvoicePageObject;
    String itemName = "iiidi";
    @Test(priority = 1)

    public void loginWithValidData() {
        loginPageObject = new LoginPage(driver);
        homePageObject = loginPageObject.loginWithValidData(emailId, password);
        Assert.assertTrue(homePageObject.getWebElement().isDisplayed());

    }

    @Test(priority = 2)

    public void openSalesInvoicesListPage() {
        salesInvoicesListPageObject = homePageObject.openSalesInvoicesListPage();
        Assert.assertTrue(salesInvoicesListPageObject.getSalesInvoicesListElement().isDisplayed());

    }

    @Test(priority = 3)

    public void createNewSalesInvoices() throws InterruptedException, AWTException {
        salesInvoicePageObject = salesInvoicesListPageObject.openNewSalesInvoice();
        //salesInvoicePageObject = salesInvoicesListPageObject.openNewSalesInvoice();
       // Assert.assertTrue(salesInvoicePageObject.getUpdateStockCheckBoxElement().isDisplayed());
        //Assert.assertTrue(salesInvoicePageObject.getUpdateStockCheckBoxElement().isSelected());
        salesInvoicePageObject.createSalesInvoice(itemName);
        salesInvoicePageObject.saveAndSubmitSalesInvoice();
       // salesInvoicesListPageObject = salesInvoicePageObject.closeWindowAfterSubmitting();
        salesInvoicesListPageObject.clearCash();
        salesInvoicesListPageObject.getSalesInvoiceNameAfterSubmitting();
        Assert.assertEquals(salesInvoicesListPageObject.getSalesInvoiceNameAfterSubmitting(), salesInvoicePageObject.getInvoiceIDName());
        //   Assert.assertEquals(salesInvoicePageObject.getAmountFieldElement().getText(),"ر.س 100.00");
        //salesInvoicePageObject.getAmountFieldElement();
       // salesInvoicePageObject.unCheckUpdateStockCheckBox();
       // Assert.assertFalse(salesInvoicePageObject.getUnCheckUpdateStockCheckBoxElement().isSelected());
     //   salesInvoicePageObject.saveAndSubmitSalesInvoice();
       // salesInvoicePageObject.closeWindowAfterSubmitting();
    }
}
