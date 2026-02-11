package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Base {

    // Make WebDriver static so it can be shared across all step classes
    public static WebDriver driver;

    // Method to open the browser
    public void openBrowser() {
        if (driver == null) { // only create a new driver if none exists
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    // Method to navigate to the AutomationExercise home page
    public void goToHomePage() {
        if (driver == null) {
            openBrowser(); // ensure driver is initialized
        }
        driver.get("https://automationexercise.com");
    }

    // Optional: method to close the browser after all tests
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null; // important: set to null so a new driver can be created later if needed
        }
    }
}
