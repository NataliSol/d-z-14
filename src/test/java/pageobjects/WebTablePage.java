package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebTablePage extends AbstractPageObject {

    private final By firstNameBy = By.id("firstName");
    private final By lastNameBy = By.id("lastName");
    private final By userEmailBy = By.id("userEmail");
    private final By ageBy = By.id("age");
    private final By salaryBy = By.id("salary");
    private final By departmentBy = By.id("department");
    private final By submitBy = By.id("submit");

    public WebTablePage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/webtables");

    }

    @Step("The user logs in with creds [{0}, {1}]")
    public void fillOutForm(String firstName, String lastName, String e_mail, String age, String salary,
                                String department) {
        new WebTablePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ReactTable -striped -highlight']")));
        WebElement addBtn = driver.findElement(By.id("addNewRecordButton"));
        addBtn.click();
        WebElement firstNameInput = driver.findElement(firstNameBy);
        WebElement lastNameInput = driver.findElement(lastNameBy);
        WebElement emailInput = driver.findElement(userEmailBy);
        WebElement ageInput = driver.findElement(ageBy);
        WebElement salaryInput = driver.findElement(salaryBy);
        WebElement departmentInput = driver.findElement(departmentBy);
        WebElement submitBtn = driver.findElement(submitBy);
        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Doe");
        emailInput.sendKeys("johndoe@example.com");
        ageInput.sendKeys("30");
        salaryInput.sendKeys("50000");
        departmentInput.sendKeys("Engineering");
        submitBtn.click();
    }

    public void editForm(String age, String salary,String department) {
        WebElement editField = driver.findElement(By.xpath("//span[@id='edit-record-4']"));
        editField.click();
        WebElement ageEditField = driver.findElement(By.id("age"));
        ageEditField.clear();
        ageEditField.sendKeys("35");
        WebElement departmentEditField = driver.findElement(By.id("department"));
        departmentEditField.clear();
        departmentEditField.sendKeys(department);
        WebElement salaryEditField = driver.findElement(By.id("salary"));
        salaryEditField.clear();
        salaryEditField.sendKeys(salary);
        WebElement updateButton = driver.findElement(By.id("submit"));
        updateButton.click();
    }
}
