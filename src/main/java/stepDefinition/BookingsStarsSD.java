package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HotelsSearchResult;

import java.util.ArrayList;
import java.util.Collections;

public class BookingsStarsSD {

    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {

    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars)
    {
        // String stars --> "5 stars"
        hotelsSearchResult.clickStar(stars.split(" ")[0]); // 5

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {
// stars --> 3 stars
        ArrayList<String> starList = hotelsSearchResult.getStarList();
        System.out.println(starList);

        // [3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]

        int ocurrance =  Collections.frequency(starList,stars.split(" ")[0]);
        int size = starList.size();

       boolean result = (ocurrance==size);

        Assert.assertTrue("Some ratings are not "+stars,result);
    }

}
