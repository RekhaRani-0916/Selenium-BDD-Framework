package stepdefinitions;

import bases.Base;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContactUsPage;
import java.time.Duration;

public class ContactUsSteps extends Base {

    ContactUsPage contactPage; // Declare the page object

//    @Given("browser is open")
//    public void browser_is_open() {
//        openBrowser();                          // from Base.java
//        contactPage = new ContactUsPage(driver); // initialize page object after driver is ready
//    }
//
//    @And("user is on AutomationExercise home page")
//    public void user_is_on_homepage() {
//        goToHomePage(); // from Base.java
//    }

    @When("user navigates to Contact Us page")
    public void user_navigates_to_Contact_Us_Page() {
    	contactPage = new ContactUsPage(driver);
        contactPage.clickContactUs(); // call method from ContactUsPage
    }

    @And("user fills Name, Email, Subject, Message")
    public void user_fills_details() {
        contactPage.enterName("Rekha Rani");                // fill name
        contactPage.enterEmail("rekha@example.com");       // fill email
        contactPage.enterSubject("Test Subject");         // fill subject
        contactPage.enterMessage("This is a test message."); // fill message
    }

    @And("user clicks Submit")
    public void user_clicks_submit() {
        contactPage.clickSubmit(); // click submit button
    }

    @Then("success message should be displayed")
    public void success_message_displayed() {

        // 1️⃣ Handle the alert after clicking submit
        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept(); // click OK on the alert

        // 2️⃣ Wait for success message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='status alert alert-success']") // same locator as ContactUsPage
        ));

        // 3️⃣ Get the success message text
        String actualMessage = contactPage.getSuccessMessage();
        String expectedMessage = "Success! Your details have been submitted successfully.";

        // 4️⃣ Verify the success message
        Assert.assertEquals(expectedMessage, actualMessage);

        // 5️⃣ Close the browser
        closeBrowser();
    }
}
