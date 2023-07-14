package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage extends BaseTest {

    public CheckboxPage() {
        PageFactory.initElements(driver, this);}

    @FindBy (css = "#tree-node > ol > li > span > label > span.rct-checkbox > svg")
    public WebElement checkBox;

    @FindBy(id = "result")
    public WebElement resultMessage;

    public void checkTheCheckBox() {
        checkBox.click();
    };


}
