package stepDefinition;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HotelsSearchResult;
import pages.HotelsSearchResult2;

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
    HotelsSearchResult2 hotelsSearchResult2  = new HotelsSearchResult2();


    @Then("^I verify system displays all hotels within \"([^\"]*)\" Km radius of center$")
    public void i_verify_system_displays_all_hotels_within_something_km_radius_of_center(String distStr)
            {
                int expectedMinDist = Integer.parseInt(distStr);

                ArrayList<Double> distList = hotelsSearchResult2.getDistList();
                System.out.println(distList);

                boolean flag = true;
                ArrayList<Double> greaterDistList = new ArrayList<>();

                for(int i=0;i<distList.size();i++)
                {
                    if(distList.get(i)>expectedMinDist)
                    {
                        flag = false;
                        greaterDistList.add(distList.get(i));
                    }
                }

                Assert.assertTrue("some distances are greater than:"+distStr+
                        "\nbelow is the greater distance list\n"+greaterDistList,flag);
    }
}
