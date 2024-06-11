package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTestPromptAlert {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void testAlert() throws InterruptedException {
        WebElement alertBtn = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
       alert.sendKeys("English");
       alert.accept();
       Thread.sleep(2000);
       Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
