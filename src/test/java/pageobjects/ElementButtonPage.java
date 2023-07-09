package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementButtonPage extends ButtonElements {
    public ElementButtonPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/elements");
    }

    public WebElement scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public void clickButton() {
        WebElement buttonsLink = getElement(buttonElement);
        scrollToElement(buttonsLink);
        buttonsLink.click();
    }

    public String clickMeGetTest() {
        clickButton();
        WebElement clickMeButton = driver.findElement(clickMeElement);
        clickMeButton.click();
        WebElement message = getElement(dynamicClickMessageElement);
        return message.getText();
    }
}
