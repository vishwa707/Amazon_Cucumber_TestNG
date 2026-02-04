package steps;

import basePkg.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void launchBrowser() {
        BaseClass.OpenBrowser("https://www.amazon.in/");
    }

    @After
    public void closeBrowser() {
        BaseClass.CloseBrowser();
    }

}
