package testngcourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHrm {
    WebDriver driver;
    @Test(priority = 1)
    void openApp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @Test(priority = 2)
    void testLogo() throws InterruptedException {
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       //Thread.sleep(5000);
        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logo));
       boolean status = logo.isDisplayed();
        System.out.println("Logo is displayed... " + status);

    }
    @Test(priority = 3)
     void  testLogin(){
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

    }
    @Test(priority = 4)
    void testLogout() throws InterruptedException {
        Thread.sleep(2000);
            driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))
                    .click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
    }
}
