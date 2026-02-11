package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ----------------- Locators -----------------
    private By signupLoginLink = By.xpath("//a[text()=' Signup / Login']");
    private By nameInput = By.xpath("//input[@name='name']");
    private By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By passwordInput = By.id("password");
    private By daysDropdown = By.id("days");
    private By monthsDropdown = By.id("months");
    private By yearsDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By offersCheckbox = By.id("optin");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By addressInput = By.id("address1");
    private By countryDropdown = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");
    private By continueButton = By.xpath("//a[contains(text(),'Continue')]");
    private By logoutButton = By.xpath("//a[contains(text(),'Logout')]");
    private By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    private By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");

    // ----------------- Methods -----------------

    public void clickSignUpLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginLink));
        WebElement el = driver.findElement(signupLoginLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        WebElement btn = driver.findElement(signupButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public void fillAccountDetails(String password, String day, String month, String year,
                                   boolean newsletter, boolean offers,
                                   String firstName, String lastName, String address,
                                   String country, String state, String city, String zipcode, String mobile) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);

        new Select(driver.findElement(daysDropdown)).selectByValue(day);
        new Select(driver.findElement(monthsDropdown)).selectByValue(month);
        new Select(driver.findElement(yearsDropdown)).selectByValue(year);

        if (newsletter && !driver.findElement(newsletterCheckbox).isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(newsletterCheckbox));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(newsletterCheckbox));
        }

        if (offers && !driver.findElement(offersCheckbox).isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(offersCheckbox));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(offersCheckbox));
        }

        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(zipcodeInput).sendKeys(zipcode);
        driver.findElement(mobileNumberInput).sendKeys(mobile);
    }

    public void clickCreateAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        WebElement btn = driver.findElement(createAccountButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

        // Wait and click Continue to go to homepage
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        WebElement cont = driver.findElement(continueButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cont);

        // Now Logout link is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }

    public void clickLogout() {
        WebElement logout = driver.findElement(logoutButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logout);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
    }

    public void login(String email, String password) {
        driver.get("https://automationexercise.com/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmailInput));
        driver.findElement(loginEmailInput).sendKeys(email);
        driver.findElement(loginPasswordInput).sendKeys(password);

        WebElement btn = driver.findElement(loginButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public boolean isUserLoggedIn() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
