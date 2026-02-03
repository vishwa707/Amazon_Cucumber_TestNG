package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class Testrunner extends AbstractTestNGCucumberTests{

}
