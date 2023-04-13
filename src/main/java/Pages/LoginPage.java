package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class LoginPage extends UtilitiesMethods {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement emailIdField;
    private WebElement passwordField;
    private WebElement loginButton;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    /********************************************************************************************************************************/
    public HomePage loginWithValidData(String emailID, String password) {

        emailIdField = driver.findElement(By.id("login_id"));
        passwordField = driver.findElement(By.id("pass"));
        loginButton = driver.findElement(By.id("login_btn"));
        clearField(emailIdField);
        clearField(passwordField);
        enterDataToInputField(emailIdField, emailID);
        enterDataToInputField(passwordField, password);
        clickOnButton(loginButton);
        return new HomePage(driver);
    }
    public void loginWithInValidEmailId(String emailID, String password) {
        emailIdField = driver.findElement(By.id("login_id"));
        passwordField = driver.findElement(By.id("pass"));
        loginButton = driver.findElement(By.id("login_btn"));
        enterDataToInputField(emailIdField, emailID);
        enterDataToInputField(passwordField, password);
        clickOnButton(loginButton);

    }
    public void loginWithInValidPassword(String emailID, String password) {

        emailIdField = driver.findElement(By.id("login_id"));
        passwordField = driver.findElement(By.id("pass"));
        loginButton = driver.findElement(By.id("login_btn"));
        enterDataToInputField(emailIdField, emailID);
        enterDataToInputField(passwordField, password);
        clickOnButton(loginButton);
    }
    public void loginWithemptyFields(String emailID, String password) {

        emailIdField = driver.findElement(By.id("login_id"));
        passwordField = driver.findElement(By.id("pass"));
        loginButton = driver.findElement(By.id("login_btn"));
        enterDataToInputField(emailIdField, emailID);
        enterDataToInputField(passwordField, password);
        clickOnButton(loginButton);
    }

    public void clickONLoginButtonWithoutdata() {

        loginButton = driver.findElement(By.id("login_btn"));
        clickOnButton(loginButton);
    }
    public WebElement getMessageForWrongID (){
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElementLocated
                (By.xpath("//*[@id='login_message']/div[2]"),"User disabled or missing"));
        return driver.findElement(By.xpath("//*[@id='login_message']/div[2]"));
    }
    public WebElement getMessageForWrongPassword (){
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElementLocated
                (By.xpath("//*[@id='login_message']/div[2]"),"Incorrect password"));
        return driver.findElement(By.xpath("//*[@id='login_message']/div[2]"));
    }
    public WebElement getMessageForemptyFields (){

        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElementLocated
                (By.xpath("//*[@id='login_message']/div[2]"),"Both login and password are required."));
        return driver.findElement(By.xpath("//*[@id='login_message']/div[2]"));
    }
}
