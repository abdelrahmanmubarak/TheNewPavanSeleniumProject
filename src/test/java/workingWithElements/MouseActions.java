package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions act = new Actions(driver);
        act.contextClick(button).perform(); // right click action

    }
}
