package testCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddNewItemTest extends TestBase {
    String newitemfilePath =System.getProperty("user.dir") + "\\ExcelSheets\\newItem.xlsx";
    //  private final String emailId = "Administrator";
    //  private final String password = "A@d3y2M6u6Nk";
    //String itemName = "iiwei";
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private SalesInvoicesListPage salesInvoicesListPageObject;
    private SalesInvoicePage salesInvoicePageObject;
    private ItemsListPage itemsListPageObject;
    private ItemPage itemPageObject;

    @DataProvider(name = "addNewItem")
    public Object[][] readingData() throws IOException {
        return readingDataMethod(newitemfilePath,3);
    }

    @Test(priority = 1, dataProvider = "addNewItem")

    public void addNewItem (String emailId, String password, String itemName) throws InterruptedException {
        loginPageObject = new LoginPage(driver);
        homePageObject = loginPageObject.loginWithValidData(emailId, password);
        Assert.assertTrue(homePageObject.getWebElement().isDisplayed());
        itemsListPageObject = homePageObject.openItemsListPage();
        itemPageObject = itemsListPageObject.createNewItem();
        itemPageObject.createAndSaveNewItem(itemName);
    }

    //   @Test(priority = 2)
    public void openItemsListPage() {
        itemsListPageObject = homePageObject.openItemsListPage();
        itemPageObject = itemsListPageObject.createNewItem();
    }

    // @Test(priority = 3, dataProvider = "testdata")
    public void createNewItem(String emailId, String password, String itemName) throws InterruptedException {
        itemPageObject.createAndSaveNewItem(itemName);
    }
}
