package mhdnurfaizzy.Test;

import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.CheckoutPage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.pageobjects.ProductCatalogue;
import mhdnurfaizzy.testComponent.baseTesting;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SauceLabs extends baseTesting {
    String fN = "Izi";
    String lN = "mhd";
    String postalCode = "40001";

    @Test(dataProvider= "getData")
    public void e2e(HashMap<String, String> input) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApplication(input.get("email"), input.get("password"));
        loginPage.welcomePage();

        //add product to cart
        ProductCatalogue productCatalog = new ProductCatalogue(driver);
        List<WebElement> products = productCatalog.getListProducts();
        productCatalog.addProductToCart(input.get("product"));

        //verify product on cart
        CartPage cartPage = loginPage.goToCartPage();
        boolean match = cartPage.verifyProductTitleDisplayed(input.get("product"));
        Assert.assertTrue(match);

        //checkout page
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.fillCheckoutInformation(fN,lN,postalCode);

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getDataJsonToMap(System.getProperty("user.dir") + "/src/main/java/mhdnurfaizzy/data/Purchase.json");
        return new Object[][] { {data.get(0)} };
    }
}
