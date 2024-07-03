package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicTableWithPagination2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
       WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
       username.clear(); username.sendKeys("demo");
       WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
       password.clear(); password.sendKeys("demo");
       driver.findElement(By.xpath("//button[@type='submit']")).click();
       driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
       driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]"))
               .click();
       String text = driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
       int total_pages = Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
       // Repeating Pages
        for (int p=1;p<=total_pages;p++){
            if (p>1){
            WebElement active_page = driver.findElement(By.xpath("//ul[@class=\"pagination\"]//*[text()="+p+"]"));
            active_page.click();
            }
        }
    }
}
