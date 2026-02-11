package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProductCartPage;
import bases.Base;

import java.time.Duration;

public class ProductSteps extends Base {

    ProductCartPage productCartPage;

    @Given("Product page is initialized")
    public void product_page_is_initialized() {
        if (driver == null) {
            throw new RuntimeException("Driver is NULL. Browser must be opened first.");
        }
        productCartPage = new ProductCartPage(driver);
    }

    @When("user navigates to the Products page")
    public void user_navigates_to_the_products_page() {
        productCartPage.clickProductsLink();
    }

    @And("user selects a product from the list")
    public void user_selects_a_product_from_the_list() {
        productCartPage.selectFirstProduct();
    }

    @And("user adds the product to the cart")
    public void user_adds_the_product_to_the_cart() {
        productCartPage.addProductAndViewCart();
    }

    @Then("the cart page should be displayed")
    public void the_cart_page_should_be_displayed() {
        Assert.assertTrue(productCartPage.isCartPageDisplayed());
    }

    @And("the selected product should be listed in the cart")
    public void the_selected_product_should_be_listed_in_the_cart() {
        Assert.assertTrue(productCartPage.isProductDisplayedInCart());
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        productCartPage.closeCheckoutModalIfPresent();
        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
    }

    @And("user chooses to register or login")
    public void user_chooses_to_register_or_login() {
        ProductCartPage page = new ProductCartPage(Base.driver);

        // Close any checkout popup
        page.closeCheckoutModalIfPresent();

        // Wait until "Signup / Login" link is visible and clickable
        WebDriverWait wait = new WebDriverWait(Base.driver, Duration.ofSeconds(20));
        WebElement signupLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Signup / Login']")));

        // Click using JS to avoid interception
        ((JavascriptExecutor) Base.driver).executeScript("arguments[0].click();", signupLink);

        // Wait for login/signup page to load
        wait.until(ExpectedConditions.urlContains("login"));

        // Now you can continue with filling signup form directly here
        Base.driver.findElement(By.name("name")).sendKeys("TestUser");
        Base.driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testuser@example.com");
        Base.driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        // Wait for account details page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Enter Account Information']")));

        // Fill account details...
        // Example:
        Base.driver.findElement(By.id("id_password")).sendKeys("Test@123");
        Base.driver.findElement(By.id("submit_account")).click();

        // Verify "Logged in as" is visible
        WebElement loggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Logged in as')]")));
        Assert.assertTrue("User not logged in successfully!", loggedIn.isDisplayed());
    }
    
    @Then("user should be able to complete signup or login")
    public void user_should_be_able_to_complete_signup_or_login() {
        // Verify that "Logged in as" is displayed
        boolean loggedIn = productCartPage.isLoggedInUserVisible();
        Assert.assertTrue("User is not logged in!", loggedIn);
    }

    @When("user enters {string} in the search box")
    public void user_enters_in_the_search_box(String productName) {
        productCartPage.enterProductInSearch(productName);
    }

    @And("user clicks on search button")
    public void user_clicks_on_search_button() {
        productCartPage.clickSearchButton();
    }

    @Then("search results related to {string} should be displayed")
    public void search_results_related_to_should_be_displayed(String productName) {
        Assert.assertTrue(productCartPage.isSearchResultsDisplayed());
        Assert.assertTrue(productCartPage.isProductFoundInSearchResults(productName));
    }
}
