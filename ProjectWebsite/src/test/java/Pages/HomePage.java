package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> cards;

    public void clickOnBookStoreApplication() {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals("Book Store Application")) {
                scrollIntoView(cards.get(i));
                cards.get(i).click();
                break;
            }
        }
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]")
    public WebElement elementsCard;

    public void clickOnElements() {
        elementsCard.click();
    }

}
