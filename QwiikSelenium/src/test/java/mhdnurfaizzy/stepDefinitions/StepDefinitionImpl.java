package mhdnurfaizzy.stepDefinitions;


import io.cucumber.java.en.And;
import mhdnurfaizzy.pageobjects.*;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.testComponent.baseTesting;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends baseTesting{

    public LoginPage loginPage;


    @Given("I landed on ecommerce page")
    public void I_landed_on_ecommerce_page() throws IOException {
        loginPage = launchApplication();
    }

    @Given("^I login with email (.+) and password (.+)$")
    public void I_login_with_email_and_password(String email, String password) {
        loginPage.loginApplication(email, password);
    }

    @When("^I added product (.+) to cart$")
    public void I_added_product_to_cart(String productName) throws InterruptedException {
        ProductCatalogue productCatalog = new ProductCatalogue(driver);
        List<WebElement> products = productCatalog.getListProducts();
        //add product to cart
        productCatalog.addProductToCart(productName);
    }

    @And("^I Checkout (.+) and fill overview (.+) (.+) (.+) information$")
    public void I_Checkout_and_fill_overview_information(String productName, String firstName, String lastName, String zip) {
        ProductCatalogue productCatalog = new ProductCatalogue(driver);
        CartPage cartPage = productCatalog.goToCartPage();
        //verify product on cart
        Boolean match = cartPage.verifyProductTitleDisplayed(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.fillCheckoutInformation(firstName,lastName,zip);
    }

    @And("^Checkout (.+) and submit order$")
    public void Checkout_and_submit_order(String productName) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        //checkoutPage
        OverviewPage overviewPage = checkoutPage.submitOrder();
        boolean matchProduct = overviewPage.verifyProductTitle(productName);
        Assert.assertTrue(matchProduct);
    }

    @Then("{string} message is displayed on confirmationPage")
    public void message_is_displayed_on_confirmationPage(String string) {
        OverviewPage overviewPage = new OverviewPage(driver);
        ConfirmationPage confirmationPage = overviewPage.finishOrder();
        String confirmMassage = confirmationPage.confirmationMessagge();
        Assert.assertTrue(confirmMassage.equalsIgnoreCase("Thank you for your order!"));

        driver.quit();
    }

    @Then("{string} message is displayed")
    public void message_invalid_email_and_password_login(String string) {
        Assert.assertEquals(string, loginPage.getErrorMessage());
        driver.quit();
    }



}
