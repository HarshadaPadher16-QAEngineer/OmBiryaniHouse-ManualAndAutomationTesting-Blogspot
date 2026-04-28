//InvalidEmail

package InvalidEmail_Test2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InvalidEmail {
    public static void main(String[] args) throws InterruptedException  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            driver.get("https://ombiryanihouse.wordpress.com/contact/");
            System.out.println("Website is opened");

            // 1. CSS Selector - Name (If Catch the "name" word in ID)
            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id*='name']")));
            nameField.sendKeys("Harshada Padher");

            // 2. CSS Selector - Phone (If Catch the "phone" word in ID)
            WebElement phoneField = driver.findElement(By.cssSelector("input[id*='phone']"));
            phoneField.sendKeys("8888160236");

            // 3. CSS Selector - Email (If Catch the "email" word in ID)
            WebElement emailField = driver.findElement(By.cssSelector("input[id*='email']"));
            emailField.sendKeys("test@123");

            // 4. CSS Selector - Message (If Catch the "Comment" word in ID)
            WebElement msgField = driver.findElement(By.cssSelector("textarea[id*='comment']"));
            msgField.sendKeys("I want 3KG chicken biryani.");

            // 5. Submit Button - We are using the Button class
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.pushbutton-wide")));
            
            // JavascriptExecutor For click the Button
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", submitBtn);
            
            System.out.println("Submit Button is Successfully");

        } catch (Exception e) {
            System.out.println("Error shows, below the Details ");
            e.printStackTrace();
        }
        
        //wait for the 50 sec
       Thread.sleep(5000);
        
        driver.quit();
    }
}