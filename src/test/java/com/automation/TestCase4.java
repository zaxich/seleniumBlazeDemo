package com.automation;

import com.automation.pages.LoggedHomePage;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("User")
public class TestCase4 extends BaseTest {

    @Test(description = "Test Case 4: Logout User")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Logout User")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter correct email address and password
            7. Click 'login' button
            8. Verify that 'Logged in as username' is visible
            9. Click 'Logout' button
            10. Verify that user is navigated to login page""")
    public void logoutUser() throws IOException, ParseException {

    }

    @Step("Verify that user is navigated to login page")
    private void verifyThatUserIsNavigatedToLoginPage() {
    }
}