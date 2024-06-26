package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDoubleClickAction {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.switchTo().frame("iframeResult");
       WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
       field1.clear();
       field1.sendKeys("Selenium Automation is great");
       Thread.sleep(500);
       WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions act = new Actions(driver);
        act.doubleClick(button).perform(); // perform a double click Action

    }
}
