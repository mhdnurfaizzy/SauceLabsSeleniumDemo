package mhdnurfaizzy.pageobjects;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConfirmationPage extends abstractComponent {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".complete-header")
    WebElement getConfirmationText;

    public String confirmationMessagge() {
        waitWebElementForAppear(getConfirmationText);
        return getConfirmationText.getText();
    }
}
