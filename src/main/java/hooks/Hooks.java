package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class Hooks {

    WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        driver = DriverFactory.getDriver();
        ExtentManager.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshotOnFailure(driver, scenario.getName());
        } else {
            ExtentManager.getTest().pass("Scenario passed");
        }

        DriverFactory.quitDriver();
        ExtentManager.flushReports();
    }
}