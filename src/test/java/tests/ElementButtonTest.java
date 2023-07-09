package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ElementButtonPage;

public class ElementButtonTest extends BaseTest {

    @Test
    public void testClickButtonLinkPositive() {
        new ElementButtonPage(driver).clickButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/buttons");
    }

    @Test
    public void testClickMeTextPositive() {
        ElementButtonPage page = new ElementButtonPage(driver);
        page.clickButton();
        String text = page.clickMeGetTest();
        Assert.assertEquals(text,"You have done a dynamic click");
    }
}
