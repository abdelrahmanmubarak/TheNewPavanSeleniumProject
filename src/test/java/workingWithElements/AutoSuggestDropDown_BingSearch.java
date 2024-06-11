package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropDown_BingSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.bing.com/");
        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
        List<WebElement> list= driver.findElements(By.xpath("//span[@class='sa_tm_text']"));
        System.out.println("List of Elements " + list.size());

        for (WebElement listItem: list){
            if (listItem.getText().contains("ide")){
                Thread.sleep(2000);
                listItem.click();
                break;
            }
        }
    }
}
