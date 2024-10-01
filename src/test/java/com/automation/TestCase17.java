package com.automation;

import com.automation.pages.CartPage;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Cart")
public class TestCase17 extends BaseTest {
    @Test(description = "Test Case 17: Remove Products From Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Remove Products From Cart")
    @Description("""
                1. Launch browser
                2. Navigate to url 'http://automationexercise.com'
                3. Verify that home page is visible successfully
                4. Add products to cart
                5. Click 'Cart' button
                6. Verify that cart page is displayed
                7. Click 'X' button corresponding to particular product
                8. Verify that product is removed from the cart""")
    public void removeProductsFromCart() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase14.verifyThatCartPageIsDisplayed();
        new CartPage(getDriver()).xButtonClick();
        verifyCartIsEmpty();
    }

    public void verifyCartIsEmpty(){
        boolean emptyCart = new CartPage(getDriver())
                .getEmptyCartSpan().isDisplayed();
        Assert.assertTrue(emptyCart, "Verify that cart is empty");
    }
}