package com.automation;

import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductsPage;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Search")
public class TestCase20 extends BaseTest {
    @Test(description = "Test Case 20: Search Products and Verify Cart After Login")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search Products and Verify Cart After Login")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify user is navigated to ALL PRODUCTS page successfully
            5. Enter product name in search input and click search button
            6. Verify 'SEARCHED PRODUCTS' is visible
            7. Verify all the products related to search are visible
            8. Add those products to cart
            9. Click 'Cart' button and verify that products are visible in cart
            10. Click 'Signup / Login' button and submit login details
            11. Again, go to Cart page
            12. Verify that those products are visible in cart after login as well""")
    public void searchProductsAndVerifyCartAfterLogin() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
        TestCase9.verifySearchedProductsIsVisible();
        List<String> productsNames = TestCase9.verifyAllTheProductsRelatedToSearchAreVisible();
        verifyAllProductsAreAddedAndCartPageIsDisplayed();
        verifyProductInCartIsAdded(productsNames);
        TestCase2.verifyLoginToYourAccountIsVisible();
        new HomePage(getDriver()).cartButtonClick();
        verifyProductInCartIsAdded(productsNames);
    }

    @Step("Verify all products are added and cart page is displayed")
    public static void verifyAllProductsAreAddedAndCartPageIsDisplayed() {
        new ProductsPage(getDriver()).addAllProducts();
        String shoppingCartText = new ProductsPage(getDriver())
                .viewCartButtonClick()
                .getShoppingCart()
                .getText();
        Assert.assertEquals(shoppingCartText, "Shopping Cart", "Verify that cart page is displayed");
    }

    public void verifyProductInCartIsAdded(List<String> productNames) {
        List<String> cartProducts = new CartPage(getDriver()).getProductsNames();
        for (int i = 0; i < productNames.size(); i++) {
            Assert.assertEquals(productNames.get(i).replaceAll(" {2}", " "), cartProducts.get(i).replaceAll(" {2}", " "), "Verify that those products are visible in cart after login as well");
        }
    }
}