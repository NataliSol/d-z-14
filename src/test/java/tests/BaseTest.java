package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;
    private final static int DURATION_TO_WAIT_DEFAULT = 4;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp(){
        driver.close();
        driver.quit();
    }
    public WebElement getElement(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public WebElement userRecord(String value){
        return getElement(By.xpath("//div[text()='"+value+"']"));
    }
    public WebElement findRecordByValue(String value) {
        return getElement(By.xpath("//div[text()='" + value + "']"));
    }
}
