package com.automation;

import com.automation.pages.LoginSignupPage;
import com.automation.utils.Util;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("User")
public class TestCase3 extends BaseTest {

    @Test(description = "Test Case 3: Login User with incorrect email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login User with incorrect email and password")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter incorrect email address and password
            7. Click 'login' button
            8. Verify error 'Your email or password is incorrect!' is visible""")
    public void loginUserWithIncorrectEmailAndPassword() {

    }

    @Step("Verify error 'Your email or password is incorrect!' is visible")
    private void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {

    }
}