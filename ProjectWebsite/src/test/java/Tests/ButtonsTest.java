package Tests;

import Base.BaseTest;
import Pages.ButtonsPage;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.RadioButtonPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {
    String expectedMessage;
    public HomePage homepagePage;
    public ElementsPage elementsPage;
    public ButtonsPage buttonsPage;
    public RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomePage();
        elementsPage = new ElementsPage();
        buttonsPage = new ButtonsPage();
        radioButtonPage = new RadioButtonPage();
        driver.manage().window().maximize();
        driver.get(homeURL);
        homepagePage.clickOnElements();
    }

    @Test (priority = 10)
    public void doubleClickButtonTest() {
        scrollIntoView(elementsPage.buttonsMenuItem);
        elementsPage.clickOnButtonsMenuItem();
        waitForURL("https://demoqa.com/buttons");
        buttonsPage.doubleClick();
        expectedMessage = "You have done a double click";
        waitForVisibility(buttonsPage.doubleClickMessage);
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), expectedMessage);
    }

    @Test (priority = 20)
    public void rightClickButtonTest() {
        scrollIntoView(elementsPage.buttonsMenuItem);
        elementsPage.clickOnButtonsMenuItem();
        waitForURL("https://demoqa.com/buttons");
        buttonsPage.rightClick();
        expectedMessage = "You have done a right click";
        waitForVisibility(buttonsPage.rightClickMessage);
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), expectedMessage);
    }

    @Test (priority = 30)
    public void clickMeButtonTest() {
        scrollIntoView(elementsPage.buttonsMenuItem);
        elementsPage.clickOnButtonsMenuItem();
        waitForURL("https://demoqa.com/buttons");
        buttonsPage.clickMe();
        expectedMessage = "You have done a dynamic click";
        waitForVisibility(buttonsPage.clickMeMessage);
        Assert.assertEquals(buttonsPage.clickMeMessage.getText(), expectedMessage);
    }

    @Test (priority = 40)
    public void clickOnYesRadioButton() {
        scrollIntoView(elementsPage.radioButtonMenuItem);
        elementsPage.clickOnRadioButtonMenuItem();
        waitForURL("https://demoqa.com/radio-button");
        radioButtonPage.clickRadioButton(radioButtonPage.yesRadioButton);
        expectedMessage = "You have selected Yes";
        waitForVisibility(radioButtonPage.yesMessage);
        Assert.assertEquals(radioButtonPage.yesMessage.getText(), expectedMessage);
    }

    @Test (priority = 50)
    public void clickOnImpressiveRadioButton() {
        scrollIntoView(elementsPage.radioButtonMenuItem);
        elementsPage.clickOnRadioButtonMenuItem();
        waitForURL("https://demoqa.com/radio-button");
        radioButtonPage.clickRadioButton(radioButtonPage.impressiveRadioButton);
        expectedMessage = "You have selected Impressive";
        waitForVisibility(radioButtonPage.impressiveMessage);
        Assert.assertEquals(radioButtonPage.impressiveMessage.getText(), expectedMessage);
    }

    @Test (priority = 60)
    public void isNoRadioButtonDisabled() {
        scrollIntoView(elementsPage.radioButtonMenuItem);
        elementsPage.clickOnRadioButtonMenuItem();
        Assert.assertFalse(radioButtonPage.noRadioButton.isEnabled());
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

