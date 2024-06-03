package mhdnurfaizzy.Test;

import mhdnurfaizzy.pageobjects.*;
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

        //Overview - fill details information
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.fillCheckoutInformation(fN,lN,postalCode);

        //Checkout and Submit Order
        OverviewPage overviewPage = checkoutPage.submitOrder();
        boolean matchProduct = overviewPage.verifyProductTitle(input.get("product"));
        Assert.assertTrue(matchProduct);

        //Confirmation Page
        ConfirmationPage confirmationPage = overviewPage.finishOrder();
        String confirmMassage = confirmationPage.confirmationMessagge();
        Assert.assertTrue(confirmMassage.equalsIgnoreCase("Thank you for your order!"));


    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getDataJsonToMap(System.getProperty("user.dir") + "/src/main/java/mhdnurfaizzy/data/Purchase.json");
        return new Object[][] { {data.get(0)} };
    }
}
