package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "productTitle")WebElement ptitle;
	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")WebElement pPrice;
	@FindBy(id = "add-to-cart-button")WebElement addcart;
	@FindBy(id = "nav-cart-count")WebElement cartcount;
	public boolean isTitleDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.visibilityOf(ptitle));
	    return ptitle.isDisplayed();
    }

    public boolean isPriceDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(pPrice));
        return pPrice.isDisplayed();
    }

    public void addToCart() {
        addcart.click();
    }

    public boolean cartUpdated() {
        return driver.getPageSource().contains("Added to Cart");
    }
	
}
