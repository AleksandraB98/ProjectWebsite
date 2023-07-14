package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProfilePage extends BaseTest {
    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName-value")
    public WebElement usernameName;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/button")
    public WebElement logoutButton;

    @FindBy(id = "gotoStore")
    public WebElement bookStoreButton;

    @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/span/div/div[1]")
    public WebElement bookStoreApplicationButton;

    @FindBy(id = "item-3")
    public WebElement profileButton;

    @FindBy(css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div.profile-wrapper > div.mt-2.buttonWrap.row > div.text-right.button.di")
    public WebElement deleteAllBooksButton;


    @FindBy(id = "closeSmallModal-ok")
    public WebElement okButton;

    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    public void goToStore() {bookStoreButton.click();}

    public void openBookStoreApplication() {
        scrollIntoView(bookStoreApplicationButton);
        bookStoreApplicationButton.click();}

    public void goToProfile() {
        openBookStoreApplication();
        scrollIntoView(profileButton);
        profileButton.click();}

    public void deleteAllBooks() throws InterruptedException{
        scrollIntoView(deleteAllBooksButton);
        deleteAllBooksButton.click();
        Thread.sleep(1000);
        clickOK();}

    public void clickOK() {okButton.click();}
}
