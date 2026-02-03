package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "twotabsearchtextbox")WebElement search;
	public String getTitle() {
		return driver.getTitle();
	}
	public void searchProduct(String product) {
        search.clear();
        search.sendKeys(product);
        search.sendKeys(Keys.ENTER);
    }

}
