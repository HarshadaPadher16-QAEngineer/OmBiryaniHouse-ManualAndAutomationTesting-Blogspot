//Homepage Validation

package HomepageValidation_Test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homepage {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();  // auto driver manage
        driver.manage().window().maximize();

        driver.get("https://ombiryanihouse.wordpress.com/");

        System.out.println("Title: " + driver.getTitle());
        
        // wait for the 30 sec
        Thread.sleep(3000);
        
        driver.quit();
       
    }
}