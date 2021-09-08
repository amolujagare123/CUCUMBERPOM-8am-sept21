package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHome;

import java.util.ArrayList;
import java.util.Collections;

import static stepDefinition.SharedSD.getDriver;

public class DarkskySD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("^I am on Darksky Home Page$")
    public void i_am_on_darksky_home_page() throws Throwable {
        Assert.assertEquals("this is not darksky home page",
                "Dark Sky - Sansad Marg, New Delhi, Delhi",
                getDriver().getTitle());
    }

    @Then("^I verify current temp is equal to Temperature from Daily Timeline$")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() throws Throwable {


        int expected = darkSkyHome.getTimelineTemp();
        int actual = darkSkyHome.getTimelineTemp();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);


        Assert.assertEquals("both temperatures are not same",expected,actual);
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented() throws Throwable {

        ArrayList<Integer> timeList = darkSkyHome.getTimeList();
        //[10, 12, 2, 4, 6, 8, 10, 12, 2, 4, 6] --> 11

        // list of diff --> [ 2,2,2,5,3,2,2,2..... ] --> 10

        ArrayList<Integer> timeDiffList = new ArrayList<>();
        for(int i = 0; i<timeList.size()-1;i++)
        {
            int time1 = timeList.get(i);
            int time2 = timeList.get(i+1);
            int timeDiff = 0;

            if(time2>time1)
                timeDiff = time2 - time1 ;

            if(time2<time1)
                timeDiff = (time2 + 12 )- time1 ;

            // all the times are in 12 hrs clock
            // so if the time2 < time 1 then we add 12 in time2
            // if all the times are in 24 hrs clock & if time2 < time1
            // then we need to add 24 in time2

            timeDiffList.add(timeDiff);

        }

        System.out.println(timeDiffList);

        int size = timeDiffList.size();
        int occurance = Collections.frequency(timeDiffList,2);

        boolean result = (size == occurance); // true / false

        Assert.assertTrue("all the differences are not 2",result);

    }

    @Then("^I verify today's lowest and highest temp is displayed correctly$")
    public void i_verify_todays_lowest_and_highest_temp_is_displayed_correctly()
             {
                 darkSkyHome.clickExpander();

                 ArrayList<String> expected = darkSkyHome.getBarTempList();
                 ArrayList<String> actual = darkSkyHome.getTimeLineTempList();

                 System.out.println("expected="+expected);
                 System.out.println("actual="+actual);

                 Assert.assertEquals(expected,actual);

             }
}
