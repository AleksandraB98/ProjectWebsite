package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SidebarPage;
import Pages.TextboxPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextboxTest extends BaseTest {
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public TextboxPage textboxPage;

    @BeforeMethod
    public void pageSetUp() {
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        textboxPage = new TextboxPage();
        driver.manage().window().maximize();
        driver.get(homeURL);
    }

    @Test (priority = 10)
    public void userCanLoadDataUsingForm() {
        homePage.clickOnElements();
        sidebarPage.clickOnButton("Text Box");
        String fullName = excelReader.getStringData("TextBox", 1, 0);
        String email = excelReader.getStringData("TextBox", 1, 1);
        String currentAddress = excelReader.getStringData("TextBox", 1, 2);
        String permanentAddress = excelReader.getStringData("TextBox", 1, 3);
        textboxPage.insertFullName(fullName);
        textboxPage.insertEmail(email);
        textboxPage.insertCurrentAddress(currentAddress);
        textboxPage.insertPermanentAddress(permanentAddress);
        textboxPage.clickOnSubmitButton();
        Assert.assertTrue(textboxPage.nameResult.getText().contains(fullName));
        Assert.assertTrue(textboxPage.emailResult.getText().contains(email));
        Assert.assertTrue(textboxPage.currentAddressResult.getText().contains(currentAddress));
        Assert.assertTrue(textboxPage.permanentAddressResult.getText().contains(permanentAddress));
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
