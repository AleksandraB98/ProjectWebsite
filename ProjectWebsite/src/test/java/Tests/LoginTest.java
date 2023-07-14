package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public HomePage homepagePage;
    public SidebarPage sidebarPage;
    public LoginPage loginPage;
    public ProfilePage profilePage;
    String validUsername;
    String validPassword;
    String invalidUsername;
    String invalidPassword;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomePage();
        sidebarPage = new SidebarPage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        driver.manage().window().maximize();
        driver.get(homeURL);
    }

    @Test(priority = 10)
    public void userCanLogIn() {
        validUsername = excelReader.getStringData("Login", 1, 0);
        validPassword = excelReader.getStringData("Login", 1, 1);
        homepagePage.clickOnBookStoreApplication();
        sidebarPage.clickOnButton("Login");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(profilePage.usernameName);
        Assert.assertTrue(profilePage.usernameName.isDisplayed());
        Assert.assertEquals(profilePage.usernameName.getText(), validUsername);

    }

    @Test (priority = 20)
    public void userCannotLogInWithWrongUsername() {
        invalidUsername = excelReader.getStringData("Login", 1, 2);
        validPassword = excelReader.getStringData("Login", 1, 1);
        homepagePage.clickOnBookStoreApplication();
        sidebarPage.clickOnButton("Login");
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.wrongCredentials);
        Assert.assertTrue(loginPage.wrongCredentials.isDisplayed());
    }

    @Test (priority = 30)
    public void userCannotLogInWithWrongPassword() {
        validUsername = excelReader.getStringData("Login", 1, 0);
        invalidPassword = excelReader.getStringData("Login", 1, 3);
        homepagePage.clickOnBookStoreApplication();
        sidebarPage.clickOnButton("Login");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.wrongCredentials);
        Assert.assertTrue(loginPage.wrongCredentials.isDisplayed());
    }


    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void pageClose() {
        driver.close();
    }
}
