package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenShots {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        // full page screenshot
       /* TakesScreenshot ts = (TakesScreenshot) driver;
          File src = ts.getScreenshotAs(OutputType.FILE);
          File trg = new File(".//Screenshot//HomePage.png");
        FileUtils.copyFile(src,trg);*/
        // screenshot of part or portion of the page
     /* WebElement featuredProductsSection = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File src = featuredProductsSection.getScreenshotAs(OutputType.FILE);
        File trg = new File(".//Screenshot//featuredProducts.png");
        FileUtils.copyFile(src,trg);*/
            // of one element
       WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File src = logo.getScreenshotAs(OutputType.FILE);
        File trg = new File(".//Screenshot//logo.png");
        FileUtils.copyFile(src,trg);

    }
}
