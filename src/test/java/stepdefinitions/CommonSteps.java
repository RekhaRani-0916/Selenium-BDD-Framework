package stepdefinitions;

import bases.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;

public class CommonSteps extends Base {

    @Given("browser is open")
    public void browser_is_open() {
        openBrowser();
    }

    @And("user is on AutomationExercise home page")
    public void user_is_on_home_page() {

        // ✅ Ensure browser is opened before navigating
        if (Base.driver == null) {
            openBrowser();   // this will initialize Base.driver
        }

        goToHomePage();      // now it's safe
    }
}
