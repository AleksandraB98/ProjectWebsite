package Tests;

import Base.BaseTest;
import Pages.CheckboxPage;
import Pages.HomePage;
import Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public CheckboxPage checkboxPage;

    @BeforeMethod
    public void pageSetUp() {
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        checkboxPage = new CheckboxPage();
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage.clickOnElements();
        sidebarPage.clickOnButton("Check Box");
    }

    @Test (priority = 10)
    public void userCanCheckACheckbox() throws InterruptedException{
        checkboxPage.checkTheCheckBox();
        Thread.sleep(1000);
        Assert.assertTrue(checkboxPage.resultMessage.isDisplayed());
    }

    @Test (priority = 20)
    public void userCanUncheckACheckbox(){
        if(checkboxPage.checkBox.isSelected()) {checkboxPage.checkTheCheckBox();}
        else  {checkboxPage.checkTheCheckBox();
        checkboxPage.checkTheCheckBox(); }
        Assert.assertFalse(checkboxPage.checkBox.isSelected());
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
