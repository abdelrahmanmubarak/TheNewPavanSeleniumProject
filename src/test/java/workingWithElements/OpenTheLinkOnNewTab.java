package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class OpenTheLinkOnNewTab {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        WebElement regLink =driver.findElement(By.linkText("Register"));
        Actions act = new Actions(driver);
        act.keyDown(Keys.COMMAND).click(regLink).keyUp(Keys.COMMAND).perform();
        // Switch to reg page
        List<String> ids = new ArrayList<>(driver.getWindowHandles());
        String id = ids.get(1);
        driver.switchTo().window(id);
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Ali");
        String HomePageID = ids.get(0);
        driver.switchTo().window(HomePageID);


    }
}
