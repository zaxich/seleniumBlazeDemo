package com.automation;

import com.automation.pages.HomePage;
import com.automation.pages.ProductsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("View")
public class TestCase18 extends BaseTest {
    @Test(description = "Test Case 18: View Category Products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("View Category Products")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that categories are visible on left side bar
            4. Click on 'Women' category
            5. Click on any category link under 'Women' category, for example: Dress
            6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
            7. On left side bar, click on any sub-category link of 'Men' category
            8. Verify that user is navigated to that category page""")
    public void viewCategoryProducts() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        new HomePage(getDriver()).womenCategoryClick();
        new HomePage(getDriver()).dressCategoryClick();
        verifyCategoryHeaderIsDisplayed("WOMEN - DRESS PRODUCTS");
        new ProductsPage(getDriver()).menCategoryClick();
        new ProductsPage(getDriver()).tShirtsCategoryClick();
        verifyCategoryHeaderIsDisplayed("MEN - TSHIRTS PRODUCTS");
    }

    public static void verifyCategoryHeaderIsDisplayed(String heading){
        String header = new ProductsPage(getDriver())
                .getTitleTextCenter()
                .getText();
        //replace double space due to ads (no adblock in mac firefox)
        Assert.assertEquals(header.replaceAll(" {2}", " "), heading, "Verify that category page is displayed and confirm text '"+ heading+ "'");
    }
}