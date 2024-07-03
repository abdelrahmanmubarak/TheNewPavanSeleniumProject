package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

public class KeyBoardActionsMultiableKeysTests {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER); // Set the page load strategy

        WebDriver driver = new ChromeDriver(options); // Pass the options here
        driver.manage().window().maximize();
        driver.get("https://text-compare.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement box1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputText1")));
        WebElement box2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputText2")));

        box1.sendKeys("Welcome to Selenium");
        System.out.println("Text entered in box1");

        // Manually set the clipboard content
        String textToCopy = "Welcome to Selenium";
        StringSelection stringSelection = new StringSelection(textToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        System.out.println("Text copied to clipboard");

        // Use JavaScript to focus on the second input box
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", box2);
        System.out.println("Focus set on box2");

        // Manually paste the clipboard content
        Actions act = new Actions(driver);
        act.sendKeys(Keys.CONTROL + "v").perform();
        System.out.println("Ctrl+V performed");

        // Slight pause to ensure actions complete
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Compare texts
        String text1 = box1.getAttribute("value");
        String text2 = box2.getAttribute("value");

        if (text1.equals(text2)) {
            System.out.println("Text Copied");
        } else {
            System.out.println("Text not Copied");
        }

       // driver.quit();
    }
}