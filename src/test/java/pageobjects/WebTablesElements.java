package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablesElements extends AbstractPageObject {
    public WebTablesElements(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/webtables");
    }

    protected final By addButton = By.id("addNewRecordButton");
    protected final By firstNameBy = By.id("firstName");
    protected final By lastNameBy = By.id("lastName");
    protected final By userEmailBy = By.id("userEmail");
    protected final By ageBy = By.id("age");
    protected final By salaryBy = By.id("salary");
    protected final By departmentBy = By.id("department");
    protected final By submitBy = By.id("submit");
    protected final By editBy = By.id("edit-record-4");
    protected final By reactTable = By.xpath("//div[@class='ReactTable -striped -highlight']");
}
