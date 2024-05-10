package mhdnurfaizzy.pageobjects;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends abstractComponent {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //PageFactory
    @FindBy(css = "#user-name")
    WebElement useremail;

    //driver.findElement(By.id("userPassword"))
    @FindBy(css="#password")
    WebElement passwordEle;

    @FindBy(css="#login-button")
    WebElement submit;

    @FindBy(css=".error-message-container.error")
    WebElement errorMessage;

    public void goTo()
    {
        driver.get("https://www.saucedemo.com/");
    }


    public void loginApplication(String email, String password) {
        useremail.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();


    }




}