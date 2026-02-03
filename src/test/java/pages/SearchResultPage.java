package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	WebDriver driver;
	public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	@FindBy(css = "div.s-main-slot")WebElement results;
	public boolean resultsDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.s-main-slot"))).isDisplayed();
    }

    public void applyBrandFilter(String brand) {
        driver.findElement(By.xpath("//div[@id='brandsRefinements']//span[text()='"+brand+"']")).click();
    }

    public void clickFirstProduct() {
        driver.findElement(By.xpath("(//div[@data-component-type])[1]//a//h2")).click();
    }

}
