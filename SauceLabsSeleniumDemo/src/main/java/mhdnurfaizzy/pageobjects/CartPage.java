package mhdnurfaizzy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class CartPage extends abstractComponent{
	
	WebDriver driver;
	
	@FindBy(css="#checkout")
	 WebElement checkoutEle;
	
	@FindBy(css="div[class='inventory_item_name']")
	 List<WebElement> productTitle;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyProductTitleDisplayed(String productName) {
		Boolean match = productTitle.stream().anyMatch(titleProduct->titleProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
}
