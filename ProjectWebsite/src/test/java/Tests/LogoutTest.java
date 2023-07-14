package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    public HomePage homepagePage;
    public SidebarPage sidebarPage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomePage();
        sidebarPage = new SidebarPage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        driver.manage().window().maximize();
        driver.get(homeURL);
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        homepagePage.clickOnBookStoreApplication();
        sidebarPage.clickOnButton("Login");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(profilePage.usernameName);
    }

    @Test(priority = 10)
    public void userCanLogOut() {
        profilePage.clickOnLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
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
