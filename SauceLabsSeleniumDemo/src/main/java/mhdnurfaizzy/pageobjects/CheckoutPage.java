package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class CheckoutPage extends abstractComponent{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#continue")
	 WebElement submit;
	
	@FindBy(css="#first-name")
	 WebElement firstName;
	@FindBy(css="#last-name")
	WebElement lastName;
	@FindBy(css="#postal-code")
	WebElement zip;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	 WebElement selectCountry;
	
	By result = By.cssSelector(".ta-results");
	
	public void fillCheckoutInformation(String fN, String lN, String postalCode) {
		firstName.sendKeys(fN);
		lastName.sendKeys(lN);
		zip.sendKeys(postalCode);

	}
	
	public OverviewPage submitOrder() {
		submit.click();
		return new OverviewPage(driver);
	}
	

}
