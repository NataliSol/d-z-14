package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebTablePage extends WebTablesElements {

    public WebTablePage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/webtables");
    }

    @Step("The user logs in with creds [{0}, {1}]")
    public void fillOutForm(String firstName, String lastName, String e_mail, String age, String salary,
                            String department) {
        new WebTablePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(reactTable));
        getElement(addButton).click();
        getElement(firstNameBy).sendKeys(firstName);
        getElement(lastNameBy).sendKeys(lastName);
        getElement(userEmailBy).sendKeys(e_mail);
        getElement(ageBy).sendKeys(age);
        getElement(salaryBy).sendKeys(salary);
        getElement(departmentBy).sendKeys(department);
        getElement(submitBy).click();
    }

    public void editForm(String age, String salary, String department) {
        getElement(editBy).click();
        updateElement(ageBy,age);
        updateElement(departmentBy,department);
        updateElement(salaryBy,salary);
        getElement(submitBy).click();
    }
    private void updateElement(By by, String keys){
        getElement(by).clear();
        getElement(by).sendKeys(keys);
    }
}
