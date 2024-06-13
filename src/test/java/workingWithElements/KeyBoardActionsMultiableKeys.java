package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionsMultiableKeys {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://text-compare.com/");
        WebElement box1 = driver.findElement(By.id("inputText1"));
        WebElement box2 = driver.findElement(By.id("inputText2"));
        box1.sendKeys("Welcome to Selenium");
        Actions act = new Actions(driver);
        // ctrl + A
        act.keyDown(Keys.CONTROL);
        act.sendKeys("a");
        act.keyUp(Keys.CONTROL);
        act.perform();
        // ctrl + C
        act.keyDown(Keys.CONTROL);
        act.sendKeys("c");
        act.keyUp(Keys.CONTROL);
        act.perform();

        // Tab Key - to shift to the second Box
        act.sendKeys(Keys.TAB);
        act.perform();
        // ctrl + V
        act.keyDown(Keys.CONTROL);
        act.sendKeys("v");
        act.keyUp(Keys.CONTROL);
        act.perform();
        // compare texts
        if (box1.getAttribute("value").equals(box2.getAttribute("value"))){
            System.out.println("Text Copied");
        }
        else{
            System.out.println("Text not Copied");
        }



    }
}
