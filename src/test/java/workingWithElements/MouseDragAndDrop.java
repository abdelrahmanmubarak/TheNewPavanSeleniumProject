package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDrop {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
       WebElement madridSource = driver.findElement(By.id("box7"));
        WebElement spainTarget  = driver.findElement(By.id("box107"));
        Actions act = new Actions(driver);
        act.dragAndDrop(madridSource,spainTarget).perform(); // perform drag&drop
    }
}
