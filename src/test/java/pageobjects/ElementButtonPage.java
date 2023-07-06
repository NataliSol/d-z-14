package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementButtonPage extends AbstractPageObject {
    public ElementButtonPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/elements");
    }

    public void clickButton() {
        new ElementButtonPage(driver);
        WebElement buttonsLink = driver.findElement(By.xpath("//span[text()='Buttons']"));
        buttonsLink.click();
    }

    public String clickMeGetTest() {
        new ElementButtonPage(driver);
        clickButton();
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();
        WebElement message = driver.findElement(By.id("dynamicClickMessage"));
        return message.getText();
    }
}
