package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageclasses.Product;
import pageclasses.Search;

public class SearchSteps {
Product product;
Search search;
    @Given("I landed on search page")
    public void i_landed_on_search_page() {
System.out.println("step1: I am on the search page");
    }

    @When("I search a product with name {string} and price {int}")
    public void i_search_a_product_with_name_and_price(String productName, Integer price) {
System.out.println("step2: search the product name:"+productName+" and price: "+price);
    product=new Product(productName,price);
    }





    @Then("product name {string} should be displayed")
    public void productNameShouldBeDisplayed(String expectedName) {
        System.out.println("step3: product name: " + expectedName + " is displayed");
        search = new Search();
       String actualName = search.displayProductName(product);
        /* if (actualName == null || !actualName.equals(expectedName)) {
            throw new AssertionError("Expected: " + expectedName + ", but got: " + actualName);
        }*/
        Assert.assertEquals(actualName,expectedName);
        System.out.println("displayed product name: "+actualName);
    }


}

