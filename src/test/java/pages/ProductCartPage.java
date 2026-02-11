package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductCartPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public ProductCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    By productsLink = By.xpath("//a[@href='/products']");
    By firstProduct = By.xpath("(//div[@class='productinfo text-center'])[1]");
    By addToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By viewCartBtn = By.xpath("//a[normalize-space()='View Cart']");
    By cartHeader = By.xpath("//li[@class='active' and contains(text(),'Shopping Cart')]");
    By productInCart = By.xpath("//tr[contains(@id,'product-')]");

    By searchInput = By.id("search_product");
    By searchButton = By.id("submit_search");
    By searchResultsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
    By searchedProducts = By.xpath("//div[@class='productinfo text-center']//p");

    public void removeAdIframeIfPresent() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "var iframe=document.getElementById('aswift_3'); if(iframe){iframe.remove();}");
        } catch (Exception ignored) {}
    }

    public void closeCheckoutModalIfPresent() {
        try {
            WebElement modal =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkoutModal")));
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].style.display='none';", modal);
        } catch (Exception ignored) {}
    }

    public void clickProductsLink() {
        WebElement products =
                wait.until(ExpectedConditions.elementToBeClickable(productsLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", products);
    }
    
    

    public void selectFirstProduct() {
        WebElement product =
                wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
        actions.moveToElement(product).perform();
    }

    public void addProductAndViewCart() {
        removeAdIframeIfPresent();
        WebElement addBtn =
                wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn);

        WebElement viewCart =
                wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);
    }

    public boolean isCartPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartHeader)).isDisplayed();
    }

    public boolean isProductDisplayedInCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productInCart)).isDisplayed();
    }
    
    public boolean isLoggedInUserVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(text(),'Logged in as')]"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterProductInSearch(String productName) {
        WebElement input =
                wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        input.clear();
        input.sendKeys(productName);
    }

    public void clickSearchButton() {
        WebElement button =
                wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        button.click();
    }

    public boolean isSearchResultsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsHeader)).isDisplayed();
    }

    public boolean isProductFoundInSearchResults(String productName) {
        List<WebElement> products = driver.findElements(searchedProducts);
        return products.stream()
                .anyMatch(p -> p.getText().toLowerCase().contains(productName.toLowerCase()));
    }
}
