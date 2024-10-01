package com.automation;

import com.automation.pages.CartPage;
import com.automation.utils.JSONReader;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Place Order")
public class TestCase16 extends BaseTest {
    @Test(description = "Test Case 16: Place Order: Login before Checkout")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Place Order: Login before Checkout")
    @Description("""
                1. Launch browser
                2. Navigate to url 'http://automationexercise.com'
                3. Verify that home page is visible successfully
                4. Click 'Signup / Login' button
                5. Fill email, password and click 'Login' button
                6. Verify 'Logged in as username' at top
                7. Add products to cart
                8. Click 'Cart' button
                9. Verify that cart page is displayed
                10. Click Proceed To Checkout
                11. Verify Address Details and Review Your Order
                12. Enter description in comment text area and click 'Place Order'
                13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
                14. Click 'Pay and Confirm Order' button
                15. Verify success message 'Your order has been placed successfully!'
                16. Click 'Delete Account' button
                17. Verify 'ACCOUNT DELETED!' and click 'Continue' button""")
    public void placeOrderLoginBeforeCheckout() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase2.loginUserWithCorrectEmailAndPassword();
        TestCase14.verifyLoggedInAsUsernameAtTop(JSONReader.existingUser("name"));
        TestCase14.verifyThatCartPageIsDisplayed();
        new CartPage(getDriver()).proceedToCheckoutButtonClick();
        TestCase14.verifyAddressDetailsAndReviewYourOrder("existing");
        TestCase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
        TestCase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
        //recreate deleted account to make the test case reusable
        TestCase14.verifyAccountCreatedAndClickContinueButton(JSONReader.existingUser("name"), JSONReader.existingUser("email"), "existing");
    }
}