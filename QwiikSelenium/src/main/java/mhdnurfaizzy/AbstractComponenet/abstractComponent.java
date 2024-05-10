package mhdnurfaizzy.AbstractComponenet;

import java.time.Duration;

import mhdnurfaizzy.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.OrderPage;

public class abstractComponent {
	
	WebDriver driver;
	
	@FindBy(css="a[class='shopping_cart_link']")
	 WebElement cartHeader;

	@FindBy(css=".app_logo")
	WebElement appLogoHeader;
	
	public abstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitElementForAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitWebElementForAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void waitElementUntillDissapear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

	public LoginPage welcomePage() {
		waitWebElementForAppear(appLogoHeader);
		appLogoHeader.isDisplayed();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}

}
