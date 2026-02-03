package steps;

import basePkg.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.Homepage;
import pages.ProductPage;
import pages.SearchResultPage;

public class Hooks {
	Homepage home;
    SearchResultPage results;
    ProductPage product;

    @Before(order = 0)
    public void launchBrowser() {
        BaseClass.OpenBrowser("https://www.amazon.in/");
    }

    @After
    public void closeBrowser() {
        BaseClass.CloseBrowser();
    }

}
