package basePkg;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BaseClass {
	public static WebDriver driver;

	public static void OpenBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	public static void CloseBrowser() {
			driver.quit();
	}
	public static void SwitchWindow() {
		String window = driver.getWindowHandle();
		Set<String> All = driver.getWindowHandles();
		for(String win:All) {
			if(!win.contains(window)) {
				driver.switchTo().window(win);
				break;
			}
		}
	}
	public static void waitForTitle(String text) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.titleContains(text));
	}
}