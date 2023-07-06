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
        WebElement firstNameField = driver.findElement(By.xpath("//div[text()='John']"));
        WebElement lastNameField = driver.findElement(By.xpath("//div[text()='Doe']"));
        WebElement e_mailField = driver.findElement(By.xpath("//div[text()='johndoe@example.com']"));
        WebElement ageField = driver.findElement(By.xpath("//div[text()='30']"));
        WebElement salaryField = driver.findElement(By.xpath("//div[text()='50000']"));
        WebElement departmentField = driver.findElement(By.xpath("//div[text()='Engineering']"));
        Assert.assertEquals(firstNameField.getText(), "John");
        Assert.assertEquals(lastNameField.getText(), "Doe");
        Assert.assertEquals(e_mailField.getText(), "johndoe@example.com");
        Assert.assertEquals(ageField.getText(), "30");
        Assert.assertEquals(salaryField.getText(), "50000");
        Assert.assertEquals(departmentField.getText(), "Engineering");
    }

    @Test
    @Description("The test is checking positive case for edit fields")
    public void testEditFormPositive() {
        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.fillOutForm("John", "Doe", "johndoe@example.com",
                "30", "50000", "Engineering");
        webTablePage.editForm("35", "60000", "Accounting");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Accounting']")).getText(), "Accounting");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='35']")).getText(), "35");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='60000']")).getText(), "60000");
    }
}
