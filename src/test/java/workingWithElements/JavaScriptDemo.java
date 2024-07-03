package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
       WebElement name= driver.findElement(By.id("name"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','John')",name);
        //Perform click action using normal click from Webdriver
        WebElement rdBtn = driver.findElement(By.xpath("//input[@value='male']"));
        rdBtn.click();
        //Perform click action using click from JavaScriptExecuter
        js.executeScript("arguments[0].click",rdBtn);

    }

}
