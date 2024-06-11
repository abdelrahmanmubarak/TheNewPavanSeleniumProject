package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleMultipleDropDowns {
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/dropdown.html");
        //approach 1
      /*Select countryDrp = new Select(driver.findElement(By.id("country"))) ;
            countryDrp.selectByVisibleText("Germany");
      Select industryDrp = new Select(driver.findElement(By.id("Industry")));
             industryDrp.selectByVisibleText("Education");*/

        // calling the Method to handle the dropdowns
        WebElement country = driver.findElement(By.id("country"));
            selectOptionFromDropDown(country,"Germany");
        WebElement industry = driver.findElement(By.id("Industry"));
        selectOptionFromDropDown(industry,"Education");

    }
    //approach 2

    public static void selectOptionFromDropDown(WebElement element, String value)
    {
        Select select = new Select(element);
        List <WebElement> allOptions = select.getOptions();
        for (WebElement option:allOptions){
            if (option.getText().equals(value)){
                option.click();
                break;
            }
        }
    }
}
