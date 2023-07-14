package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextboxPage extends BaseTest {
    public TextboxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement fullNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressField;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div")
    public WebElement submitButton;

    @FindBy(id = "name")
    public WebElement nameResult;

    @FindBy(id = "email")
    public WebElement emailResult;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")
    public WebElement currentAddressResult;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]")
    public WebElement permanentAddressResult;

    @FindBy(id = "output")
    public WebElement outputTextBox;

    public void insertFullName(String fullName) {
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
    }

    public void insertEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void insertCurrentAddress(String currentAddress) {
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }

    public void insertPermanentAddress(String permanentAddress) {
        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton() {
        scrollIntoView(submitButton);
        submitButton.click();
    }
}
