package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;

import java.util.List;

public class OverviewPage extends abstractComponent{
	
	WebDriver driver;
	
	public OverviewPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".inventory_item_name")
	List<WebElement> productTitle;

	@FindBy(css="#finish")
	WebElement finishBtn;
	
	public Boolean verifyProductTitle(String productName) {
		Boolean match = productTitle.stream().anyMatch(titleProduct->titleProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public ConfirmationPage finishOrder() {
		finishBtn.click();
		return new ConfirmationPage(driver);
	}
}
