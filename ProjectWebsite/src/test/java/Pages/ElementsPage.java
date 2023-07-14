package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BaseTest {
    public ElementsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "item-2")
    public WebElement radioButtonMenuItem;

    @FindBy(id = "item-4")
    public WebElement buttonsMenuItem;

    public void clickOnRadioButtonMenuItem() {
        radioButtonMenuItem.click();
    }

    public void clickOnButtonsMenuItem() {
        buttonsMenuItem.click();
    }
}

