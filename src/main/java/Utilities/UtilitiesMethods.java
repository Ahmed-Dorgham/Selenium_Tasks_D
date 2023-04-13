package Utilities;

import org.openqa.selenium.WebElement;

public class UtilitiesMethods {


    public void clickOnButton(WebElement button) {
        button.click();

    }

    public void enterDataToInputField(WebElement inputField, String data) {
      //  inputField.clear();
        inputField.sendKeys(data);
    }
    public void clearField(WebElement inputField) {
        inputField.clear();

    }
    public void submitDataViaInputField(WebElement inputField, String data) {
        inputField.sendKeys(data);
        inputField.submit();
    }
}
