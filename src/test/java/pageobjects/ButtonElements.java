package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonElements extends AbstractPageObject {
    public ButtonElements(WebDriver driver) {
        super(driver);
    }

    protected final By buttonElement=By.xpath("//span[text()='Buttons']");
    protected final By clickMeElement=By.xpath("//button[text()='Click Me']");
    protected final By dynamicClickMessageElement= By.id("dynamicClickMessage");
}
