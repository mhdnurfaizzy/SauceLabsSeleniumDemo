package mhdnurfaizzy.Test;

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

    @Test(dataProvider= "getData")
    public void e2e(HashMap<String, String> input) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApplication(input.get("email"), input.get("password"));
        loginPage.welcomePage();

        //verify product
        ProductCatalogue productCatalog = new ProductCatalogue(driver);
        List<WebElement> products = productCatalog.getListProducts();
        productCatalog.addProductToCart(input.get("product"));
//        Assert.assertTrue(match);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getDataJsonToMap(System.getProperty("user.dir") + "/src/main/java/mhdnurfaizzy/data/Purchase.json");
        return new Object[][] { {data.get(0)} };
    }
}
