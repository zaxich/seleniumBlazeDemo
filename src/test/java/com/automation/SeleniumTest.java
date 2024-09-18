package com.automation;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SeleniumTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test the login functionality of the Form Authentication page")
    @Epic("Login Tests")
    @Feature("Form Authentication")
    public void testLoginPage() {
        openHomePage();
        navigateToFormAuthentication();

        fillLoginForm("tomsmith", "SuperSecretPassword!");

        validateLoginSuccess();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test the login functionality of the Check Box page")
    @Feature("Check Box")
    public void testCheckBox() {
        // Open the page and validate the title
        openHomePage();
        navigateToCheckBox();
        doCheckList();
    }

    @Step("Open 'The Internet' home page")
    public void openHomePage() {
        getDriver().get("https://the-internet.herokuapp.com/");
    }

    @Step("Navigate to 'Form Authentication'")
    public void navigateToFormAuthentication() {
        getDriver().findElement(By.linkText("Form Authentication")).click();
    }

    @Step("Navigate to 'CheckBox'")
    public void navigateToCheckBox() {
        getDriver().findElement(By.linkText("Checkboxes")).click();
    }

    @Step("Do Checklist'")
    public void doCheckList() {
        getDriver().findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
    }

    @Step("Fill login form with username: {0} and password: {1}")
    public void fillLoginForm(String username, String password) {
        getDriver().findElement(By.id("username")).sendKeys(username);
        getDriver().findElement(By.id("password")).sendKeys(password);
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Step("Validate login success message")
    @Attachment(value = "Login Result", type = "text/plain")
    public String validateLoginSuccess() {
        String successMessage = getDriver().findElement(By.cssSelector(".flash.success")).getText();
        assertTrue(getDriver().findElement(By.cssSelector(".flash.success")).isDisplayed());
        return successMessage;
    }
}
