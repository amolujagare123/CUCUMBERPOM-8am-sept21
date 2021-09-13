package stepDefinition;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HotelsSearchResult;

import java.util.ArrayList;

public class HotelList {

    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Then("^I verify \"([^\"]*)\" is within radius$")
    public void i_verify_something_is_within_radius(String hotelName) throws Throwable {

        ArrayList<String> hotelList = hotelsSearchResult.getHotelList();
        System.out.println(hotelList);
        boolean flag = false;
        for(int i=0;i<hotelList.size();i++)
        {
            System.out.println(hotelList.get(i));

            if(hotelList.get(i).contains(hotelName))
            {
                flag = true;
            }
        }

        Assert.assertTrue(hotelName+": this hotel is not there in the search result",flag);

    }
}
