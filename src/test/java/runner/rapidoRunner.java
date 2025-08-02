package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src\\test\\resources\\Features\\RapidoBooking.feature"},
        glue={"stepDefinitions"},
        tags="not @All",
        plugin={"pretty"},
        dryRun=false
)
public class rapidoRunner {

}
