package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropDown {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:9222");
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/dropdown.html");
       WebElement dropDownCountryEle= driver.findElement(By.id("country"));
        Select select = new Select(dropDownCountryEle);
      /*  select.selectByVisibleText("Germany");
        select.selectByIndex(6);*/
      List<WebElement> allOptions = select.getOptions();
      for ( WebElement option:allOptions){
          if (option.getText().equals("Germany")){
                option.click();
                break;
          }
      }

    }
}
