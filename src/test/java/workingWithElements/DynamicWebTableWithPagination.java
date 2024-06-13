package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableWithPagination {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        //Login
       WebElement userName= driver.findElement(By.id("input-username"));
       userName.clear();
       userName.sendKeys("demo");
       WebElement passWord = driver.findElement(By.id("input-password"));
       passWord.clear();
       passWord.sendKeys("demo");
       driver.findElement(By.xpath("//button[@type='submit']")).click();
       // Sales==>Orders
        driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();


    }
}
