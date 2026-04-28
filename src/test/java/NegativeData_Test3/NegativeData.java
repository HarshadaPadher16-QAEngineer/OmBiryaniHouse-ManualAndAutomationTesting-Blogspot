// Negative Data or Empty form

package NegativeData_Test3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NegativeData {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://ombiryanihouse.wordpress.com/contact/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Correct Submit Button XPath (button is available, no input)
            WebElement submitBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Submit')]")
                )
            );

            // Scroll to button
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);

            Thread.sleep(3000);

            // Force click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);

            System.out.println("Submit clicked ✅");

            // Error message wait
            WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Please make sure all fields are valid')]")
                )
            );

            System.out.println("Error message displayed ✅");
            System.out.println("Message: " + errorMsg.getText());

        } catch (Exception e) {
            System.out.println("Test Failed ❌");
            e.printStackTrace();
        }

        driver.quit();
    }
}