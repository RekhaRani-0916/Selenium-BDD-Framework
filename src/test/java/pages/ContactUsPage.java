package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage{
	
	private WebDriver driver;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Locators
    private By contactUsLink = By.linkText("Contact us");          // Contact Us link on homepage
    private By nameField = By.name("name");                        // Name input box
    private By emailField = By.name("email");                      // Email input box
    private By subjectField = By.name("subject");                  // Subject input box
    private By messageField = By.name("message");                  // Message textarea
    private By submitButton = By.name("submit");                   // Submit button
    private By successMessage = By.xpath("//div[@class='status alert alert-success']"); // Success message
	
	// Methods
    public void clickContactUs() {
    	driver.findElement(contactUsLink).click();
    }
    
    public void enterName(String name) {
    	driver.findElement(nameField).sendKeys(name);
    }
    
    public void enterEmail(String email) {
    	driver.findElement(emailField).sendKeys(email);
    }
    
    public void enterSubject(String subject) {
    	driver.findElement(subjectField).sendKeys(subject);
    }
    
    public void enterMessage(String message) {
    	driver.findElement(messageField).sendKeys(message);
    }
    
    public void clickSubmit() {
    	driver.findElement(submitButton).click();
    }
    
    public String getSuccessMessage() {
    	return driver.findElement(successMessage).getText();
    }
    
    
    
}