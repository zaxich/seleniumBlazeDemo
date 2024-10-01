package com.automation;

import com.automation.pages.HomePage;
import com.automation.pages.ProductsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("View")
public class TestCase19 extends BaseTest {
    @Test(description = "Test Case 19: View & Cart Brand Products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("View & Cart Brand Products")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify that Brands are visible on left side bar
            5. Click on any brand name
            6. Verify that user is navigated to brand page and brand products are displayed
            7. On left side bar, click on any other brand link
            8. Verify that user is navigated to that brand page and can see products""")
    public void viewCartBrandProducts() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
        new ProductsPage(getDriver()).poloBrandClick();
        TestCase18.verifyCategoryHeaderIsDisplayed("BRAND - POLO PRODUCTS");
        new ProductsPage(getDriver()).madameBrandClick();
        TestCase18.verifyCategoryHeaderIsDisplayed("BRAND - MADAME PRODUCTS");
    }
}