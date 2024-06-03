package mhdnurfaizzy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class ProductCatalogue extends abstractComponent{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
//	@FindBy(css=".mb-3")
//	 List<WebElement> products;

	@FindBy(css="div[class='inventory_item']")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	 WebElement spinner;
	
	By productsBy = By.cssSelector("div[class='inventory_item']");
	By addToCart = By.cssSelector("#add-to-cart-sauce-labs-backpack");
	By toastMessage = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getListProducts() {
		waitElementForAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name ']")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
//		waitElementForAppear(toastMessage);
//		waitElementUntillDissapear(spinner);
		Thread.sleep(1000);
		

	}
	

}
