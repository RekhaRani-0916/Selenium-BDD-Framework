package stepdefinitions;

import bases.Base;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LogIn extends Base {

    LoginPage signinPage;
    String userName;
    String userEmail;
    String userPassword;

    @When("user clicks on Signup Login Link")
    public void user_clicks_Signup_link() {
        signinPage = new LoginPage(driver);
        signinPage.clickSignUpLoginLink();
    }

    @And("user enters name and email for signup")
    public void user_enters_details() {
        userName = "Rekha Rani";
        userEmail = "rekha" + System.currentTimeMillis() + "@example.com"; // dynamic email
        userPassword = "Test@123";

        signinPage.enterName(userName);
        signinPage.enterEmail(userEmail);
    }

    @And("user clicks on Signup button")
    public void user_clicks_on_signup_button() {
        signinPage.clickSignUpButton();
    }

    @And("user fills account details")
    public void user_fills_account_details() {
        signinPage.fillAccountDetails(
                userPassword,
                "10", "5", "1990",     // DOB
                true, true,            // newsletter & offers
                "Rekha", "Rani",       // first & last name
                "123 Street", "United States", "California", "Los Angeles", "90001",
                "1234567890"
        );
    }

    @And("user clicks on Create Account button")
    public void user_clicks_on_create_account_button() {
        signinPage.clickCreateAccountButton();
    }

    @Then("account should be created successfully")
    public void account_should_create_successfully() {
        System.out.println("Account created successfully: " + userEmail);
    }

    @And("user logs out")
    public void user_logs_out() {
        signinPage.clickLogout();
    }

    @And("user logs in with same credentials")
    public void user_logs_in_with_same_credentials() {
        signinPage.login(userEmail, userPassword);
    }

    @Then("user is logged in successfully")
    public void user_logged_successfully() {
        if (signinPage.isUserLoggedIn()) {
            System.out.println("User logged in successfully: " + userEmail);
        } else {
            throw new RuntimeException("Login failed for user: " + userEmail);
        }
    }
}
