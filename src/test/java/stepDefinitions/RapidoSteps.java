package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RapidoSteps {

    @Given("user wants to select bike type from rapido")
    public void user_wants_to_select_bike_type_from_rapido() {
        System.out.println("step1: user selects bike type");
    }

    @When("user select bike {string} and pickup point {string} to drop point {string}")
    public void user_select_bike_and_pickup_point_to_drop_point(String bikeName, String start, String drop) {
        System.out.println("steps2: user selects " + bikeName + " starts from " + start + " dropped at " + drop);
    }


    @Then("Driver starts the journey")
    public void driver_starts_the_journey() {
        System.out.println("step3: driver starts the journey");
    }

    @Then("user reached the station")
    public void user_reached_the_station() {
        System.out.println("step4: user reaches the destination");
    }

    @Then("user pays {string} INR")
    public void user_pays_inr(String money) {
        System.out.println("step5: user pays " + money + " INR to the driver");
    }
}
