package testCases;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase{
  //  private WebDriver driver;
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    String invalidIDFilePath = System.getProperty("user.dir") + "\\ExcelSheets\\invalidIDForLoginn.xlsx";
    String emptyFieldsFilePath = System.getProperty("user.dir") + "\\ExcelSheets\\emptyIDField.xlsx";
    String invalidPasswordFilePath =System.getProperty("user.dir") + "\\ExcelSheets\\invalidPasswordForLoginn.xlsx";
    String validDataFilePath =System.getProperty("user.dir") + "\\ExcelSheets\\validData.xlsx";
    @DataProvider(name = "invalidID")
    public Object[][] readingIDData() throws IOException {
        return readingDataMethod(invalidIDFilePath , 2);
    }
    @DataProvider(name = "validData")
    public Object[][] readingValidData() throws IOException {
        return readingDataMethod(validDataFilePath , 2);
    }
    @DataProvider(name = "invalidPassword")
    public Object[][] readingPasswordData() throws IOException {
        return readingDataMethod(invalidPasswordFilePath,2);
    }
    @DataProvider(name = "loginWithemptyID")
    public Object[][] readingemptyFields() throws IOException {
        return readingDataMethod(emptyFieldsFilePath, 2);
    }
    @Test(priority = 1 )
    public void clickONLoginButtonWithoutdata ()
    {
        loginPageObject = new LoginPage(driver);
        loginPageObject.clickONLoginButtonWithoutdata();
        Assert.assertTrue(loginPageObject.getMessageForemptyFields().getText().contains("Both login and password are required."));
    }
  @Test(priority = 2 , dataProvider = "invalidID")
    public void loginWithInValidID(String emailid , String password){
      loginPageObject = new LoginPage(driver);
       loginPageObject.loginWithInValidEmailId(emailid,password);
      Assert.assertTrue(loginPageObject.getMessageForWrongID().getText().contains("User disabled or missing"));

    }
    @Test(priority = 3, dataProvider = "invalidPassword" )
    public void loginWithInValidPassword(String emailid , String password){
        loginPageObject = new LoginPage(driver);
        loginPageObject.loginWithInValidPassword(emailid,password);
        Assert.assertTrue(loginPageObject.getMessageForWrongPassword().getText().contains("Incorrect password"));
    }
    @Test(priority = 4, dataProvider = "loginWithemptyID" )
    public void loginWithemptyID(String emailid , String password){
        loginPageObject = new LoginPage(driver);
        loginPageObject.loginWithemptyFields(emailid,password);
        Assert.assertTrue(loginPageObject.getMessageForemptyFields().getText().contains("Both login and password are required."));

    }

  @Test(priority = 5 , dataProvider = "validData")
    public void loginWithValidData(String emailid , String password){
      loginPageObject = new LoginPage(driver);
        homePageObject = loginPageObject.loginWithValidData(emailid, password);
        Assert.assertTrue(homePageObject.getWebElement().isDisplayed());
    }
}
