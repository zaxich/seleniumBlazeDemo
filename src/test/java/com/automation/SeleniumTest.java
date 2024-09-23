package com.automation;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class SeleniumTest extends BaseTest{
    public String productName = "";
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test DemoBlaze")
    @Feature("Test Add to Cart")
    public void testAddToCart(){
        openLaptopCategory();
        navigateToFirstLaptop();
        addToCart();
        closeAlert();
        openCartPage();
        verifyAddedLaptop();
    }

    @Step("Open Laptop Category")
    public void openLaptopCategory(){
        waitUntilPageIsFullyLoaded();

        By by = By.xpath("//a[text()=\"Laptops\"]");
        WebDriverWait w = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement element = w.until(ExpectedConditions.elementToBeClickable(by));
        System.out.println("masuk sini: " + element.getText());
        element.sendKeys(Keys.ENTER);

        //wait for the category data to be changed
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Step("Navigate to first laptop")
    public void navigateToFirstLaptop(){
        productName = getDriver().findElement(By.xpath("//div[@id=\"tbodyid\"][1]/div[1]//a")).getText();
        getDriver().findElement(By.xpath("//div[@id=\"tbodyid\"][1]/div[1]//a")).click();
    }

    @Step("Open Laptop Category")
    public void addToCart(){
        String url = getDriver().getCurrentUrl();
        assertTrue("url is incorrect", url.contains("prod.html"));

        waitUntilPageIsFullyLoaded();
        wait.until(d -> getDriver().findElement(By.xpath("//a[text()=\"Add to cart\"]")).isDisplayed());
        getDriver().findElement(By.xpath("//a[text()=\"Add to cart\"]")).click();
    }

    @Step("Close Alert")
    public void closeAlert(){
        getDriver().switchTo().alert().accept();
    }

    @Step("Open Cart Page")
    public void openCartPage(){
        getDriver().findElement(By.xpath("//a[text()=\"Cart\"]")).click();
    }

    @Step("Verify Laptop is Added Correctly")
    public void verifyAddedLaptop(){
        List<WebElement> productNames = getDriver().findElements(By.xpath("//tbody//tr/td[2]"));

        boolean productPresent = false;
        for (WebElement productRowName : productNames){
            if (productRowName.toString().equals(productName)){
                productPresent = true;
            }
        }

        assertTrue("product isn't found in cart", productPresent);
    }

    public void waitUntilPageIsFullyLoaded(){
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}