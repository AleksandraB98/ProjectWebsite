package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStorePage extends BaseTest {

    WebElement product;
   public BookStorePage()  {
       PageFactory.initElements(driver, this);
   }

   @FindBy(linkText = "Git Pocket Guide")
    public WebElement gitPocketGuide;

   @FindBy(linkText = "Learning JavaScript Design Patterns")
   public WebElement learningJavaScriptDesignPatterns;

   @FindBy(linkText = "Designing Evolvable Web APIs with ASP.NET")
   public WebElement designingEvolvableWebAPIsWithASPNET;

   @FindBy(linkText = "Speaking JavaScript")
   public WebElement speakingJavaScript;

   @FindBy(css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div.books-wrapper > div.profile-wrapper > div.mt-2.fullButtonWrap.row > div.text-right.fullButton")
   public WebElement addButton;

   @FindBy(css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div.books-wrapper > div.profile-wrapper > div.mt-2.fullButtonWrap.row > div.text-left.fullButton")
   public WebElement goBackToTheStoreButton;

   public void chooseBook(WebElement product) {
       product.click();
   }

   public void addBook(WebElement product) {
       scrollIntoView(product);
       product.click();
       scrollIntoView(addButton);
       addButton.click();
   }

   public void goBack() {
       scrollIntoView(goBackToTheStoreButton);
       goBackToTheStoreButton.click();
   }
}
