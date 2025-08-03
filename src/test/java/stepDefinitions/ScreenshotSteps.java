package stepDefinitions;

import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ScreenshotSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("I open Google")
    public void i_open_google() {
        driver.get("https://www.google.com");
    }

    @Then("I force a failure to check screenshot")
    public void i_force_failure() {
       // Assert.fail("Intentional failure for screenshot test");
    }
}
