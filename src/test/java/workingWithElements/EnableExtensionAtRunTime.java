package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class EnableExtensionAtRunTime {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        File file = new File("/Users/abdelrahmanmubarak/Downloads/SelectorsHubCRX.crx");
        options.addExtensions(file);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://text-compare.com/");
    }
}
