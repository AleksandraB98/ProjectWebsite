package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class BooksTest extends BaseTest {
    public HomePage homepagePage;
    public SidebarPage sidebarPage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    public BookStorePage bookStorePage;
    String expectedMessage;
    String otherMessage;
    String notificationMessage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomePage();
        sidebarPage = new SidebarPage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        bookStorePage = new BookStorePage();
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

    @Test (priority = 10)
    public void userCanAddABook() throws InterruptedException{
        scrollIntoView(profilePage.bookStoreButton);
        profilePage.goToStore();
        waitForVisibility(bookStorePage.gitPocketGuide);
        bookStorePage.addBook(bookStorePage.gitPocketGuide);
        Thread.sleep(1500);
        expectedMessage = "Book added to your collection.";
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedMessage);
        driver.switchTo().alert().accept();
        driver.get("https://demoqa.com/profile");
        profilePage.deleteAllBooks();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

    @Test (priority = 20)
    public void UserCanAddTwoBooks() throws InterruptedException {
        scrollIntoView(profilePage.bookStoreButton);
        profilePage.goToStore();
        waitForVisibility(bookStorePage.gitPocketGuide);
        bookStorePage.addBook(bookStorePage.gitPocketGuide);
        Thread.sleep(1000);
        expectedMessage = "Book added to your collection.";
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedMessage);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        bookStorePage.goBack();
        waitForVisibility(bookStorePage.learningJavaScriptDesignPatterns);
        bookStorePage.addBook(bookStorePage.learningJavaScriptDesignPatterns);
        Thread.sleep(1000);
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedMessage);
        driver.switchTo().alert().accept();
        driver.get("https://demoqa.com/profile");
        profilePage.deleteAllBooks();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

    @Test (priority = 30)
    public void userCanAddThreeBooks() throws InterruptedException{
        scrollIntoView(profilePage.bookStoreButton);
        profilePage.goToStore();
        waitForVisibility(bookStorePage.gitPocketGuide);
        bookStorePage.addBook(bookStorePage.gitPocketGuide);
        Thread.sleep(1000);
        expectedMessage = "Book added to your collection.";
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedMessage);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        bookStorePage.goBack();
        waitForVisibility(bookStorePage.learningJavaScriptDesignPatterns);
        bookStorePage.addBook(bookStorePage.learningJavaScriptDesignPatterns);
        Thread.sleep(1000);
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedMessage);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        bookStorePage.goBack();
        waitForVisibility(bookStorePage.designingEvolvableWebAPIsWithASPNET);
        bookStorePage.addBook(bookStorePage.designingEvolvableWebAPIsWithASPNET);
        Thread.sleep(1000);
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedMessage);
        driver.switchTo().alert().accept();
        driver.get("https://demoqa.com/profile");
        profilePage.deleteAllBooks();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

    }

    @Test (priority = 40)
    public void userCanAddFourBooks() throws InterruptedException{
        scrollIntoView(profilePage.bookStoreButton);
        profilePage.goToStore();
        waitForVisibility(bookStorePage.gitPocketGuide);
        bookStorePage.addBook(bookStorePage.gitPocketGuide);
        Thread.sleep(1000);
        expectedMessage = "Book added to your collection.";
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedMessage);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        bookStorePage.goBack();
        waitForVisibility(bookStorePage.learningJavaScriptDesignPatterns);
        bookStorePage.addBook(bookStorePage.learningJavaScriptDesignPatterns);
        Thread.sleep(1000);
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedMessage);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        bookStorePage.goBack();
        waitForVisibility(bookStorePage.designingEvolvableWebAPIsWithASPNET);
        bookStorePage.addBook(bookStorePage.designingEvolvableWebAPIsWithASPNET);
        Thread.sleep(1000);
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedMessage);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        bookStorePage.goBack();
        waitForVisibility(bookStorePage.speakingJavaScript);
        bookStorePage.addBook(bookStorePage.speakingJavaScript);
        Thread.sleep(1000);
        Assert.assertEquals(driver.switchTo().alert().getText(), expectedMessage);
        driver.switchTo().alert().accept();
        driver.get("https://demoqa.com/profile");
        profilePage.deleteAllBooks();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

    @Test (priority = 50)
    public void userCanDeleteAllBooks() throws InterruptedException{
        profilePage.deleteAllBooks();
        Thread.sleep(1000);
        expectedMessage = "All Books deleted.";
        otherMessage = "No books available in your's collection!";
        notificationMessage = driver.switchTo().alert().getText();
        Assert.assertTrue(notificationMessage.equals(expectedMessage) || notificationMessage.equals(otherMessage));
        driver.switchTo().alert().accept();
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
