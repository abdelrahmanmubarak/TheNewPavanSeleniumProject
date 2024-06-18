package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class DropDownUsingBootStrap {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
        driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
        Thread.sleep(2000);
      List <WebElement> btnDropDown = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
        System.out.println("Number of Options is " + btnDropDown.size());

        for (WebElement btn: btnDropDown){
            if (btn.getText().equals("Another action")){
                btn.click();
                break;
            }
        }
    }
}
