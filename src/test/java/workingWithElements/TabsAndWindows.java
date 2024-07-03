package workingWithElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
