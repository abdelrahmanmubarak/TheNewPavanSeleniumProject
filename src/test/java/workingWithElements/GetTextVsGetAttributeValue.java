package workingWithElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextVsGetAttributeValue {
   public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@id='Email']"));
      /*  emailInputBox.clear();
        emailInputBox.sendKeys("admin123@gmail.com");*/

        //capturing text from input box
       /* System.out.println("Attribute Value is " + emailInputBox.getAttribute("value"));
        System.out.println("Attribute Value is " + emailInputBox.getText());*/
        //login button
       WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        System.out.println(button.getAttribute("type"));




    }

}
