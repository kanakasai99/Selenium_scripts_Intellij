package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

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
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentManager.getTest().fail("Scenario failed: " + scenario.getName())
                    .addScreenCaptureFromBase64String(
                            ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64),
                            "Failed Screenshot"
                    );
        } else {
            ExtentManager.getTest().pass("Scenario passed");
        }
        DriverFactory.quitDriver();
        ExtentManager.flushReports();
    }
}
