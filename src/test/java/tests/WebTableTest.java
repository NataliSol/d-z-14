package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.WebTablePage;

import java.time.Duration;

public class WebTableTest extends BaseTest {

    @Test
    @Description("The test is checking positive case for filling out form fields")
    public void testFillOutFormPositive() {
        new WebTablePage(driver).fillOutForm("John", "Doe", "johndoe@example.com",
                "30", "50000", "Engineering");
        Assert.assertTrue(userRecord("John").isDisplayed(), "John element is not displayed");
        Assert.assertTrue(userRecord("Doe").isDisplayed(), "Doe element is not displayed");
        Assert.assertTrue(userRecord("johndoe@example.com").isDisplayed(), "johndoe@example.com element is not displayed");
        Assert.assertTrue(userRecord("30").isDisplayed(), "30 element is not displayed");
        Assert.assertTrue(userRecord("50000").isDisplayed(), "50000 element is not displayed");
        Assert.assertTrue(userRecord("Engineering").isDisplayed(), "Engineering element is not displayed");
    }

    @Test
    @Description("The test is checking positive case for edit fields")
    public void testEditFormPositive() {
        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.fillOutForm("John", "Doe", "johndoe@example.com",
                "30", "50000", "Engineering");
        webTablePage.editForm("35", "60000", "Accounting");
        Assert.assertTrue(userRecord("Accounting").isDisplayed(), "Accounting element is not displayed");
        Assert.assertTrue(userRecord("35").isDisplayed(), "30 element is not displayed");
        Assert.assertTrue(userRecord("60000").isDisplayed(), "60000 element is not displayed");
    }
}
