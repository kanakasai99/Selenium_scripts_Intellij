package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty"},
        monochrome = true
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}