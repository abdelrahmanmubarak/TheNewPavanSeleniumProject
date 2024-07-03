package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MouseDoubleClickAction {
    public static void main(String[] args) throws InterruptedException {
        // Set the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.NONE);

        // Initialize the ChromeDriver with the options
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Open the URL
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");

        // Create an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the iframe to be available and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("iframeResult")));

        // Find the elements and perform actions
        WebElement field1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='field1']")));
        WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));

        field1.clear();
        field1.sendKeys("Selenium Automation is great");
        Thread.sleep(500); // Sleep for a short while to simulate a realistic interaction

        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions act = new Actions(driver);
        act.doubleClick(button).perform(); // Perform a double-click action

        // Validation: Box2 should contain "Selenium Automation is great"
        String text = field2.getAttribute("value");
        System.out.println("Captured Value is " + text);
        if (text.equals("Selenium Automation is great")) {
            System.out.println("Text copied");
        } else {
            System.out.println("Text not copied");
        }

        // Quit the driver
        driver.quit();
    }
}
