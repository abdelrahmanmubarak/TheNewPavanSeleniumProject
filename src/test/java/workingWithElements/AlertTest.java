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

public class AlertTest {
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
        WebElement alertBtn = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        alertBtn.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("I am a JS Alert",alertText);
        System.out.println( alertText = alert.getText());
        alert.accept();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.id("result")).getText()
                .contains("You successfully clicked an alert"
                        ));

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
