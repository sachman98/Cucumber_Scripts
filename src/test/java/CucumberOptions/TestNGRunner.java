package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features", glue = "StepDefinitions",dryRun = false, monochrome = true,  tags = "@CSV", plugin = {
		"pretty", "html:target/cucumber.html", "json:target/cucumber.json" })
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
