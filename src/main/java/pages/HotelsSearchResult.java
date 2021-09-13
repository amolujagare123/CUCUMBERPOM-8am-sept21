package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static stepDefinition.SharedSD.getDriver;

public class HotelsSearchResult extends Base{

    By starRatingList = By.xpath("//span[contains(@aria-label,'out of 5')]");

    By hotelList = By.xpath("//span[contains(@class,'sr-hotel__name')]");


    public ArrayList<String> getHotelList() {

       return getElementTextList(hotelList);
    }

    public ArrayList<String> getStarList()
    {
        List<WebElement> starRatingListRaw = getDriver().findElements(starRatingList);
        ArrayList<String> starList = new ArrayList<>();
        for(int i=0;i<starRatingListRaw.size();i++)
        {
            String starRaw = starRatingListRaw.get(i).getAttribute("aria-label"); // "4 out of 5"

            String star = starRaw.split(" ")[0];

            starList.add(star);

        }
        return starList;
    }





    public void clickStar(String starValue )    {

      // By starLocator = By.xpath("//div[@data-id='filter_class']//a[@data-value='"+starValue+"']");
       By starLocator = By.xpath("//div[@data-id='filter_class']//a[@data-id='class-"+starValue+"']");
        clickOn(starLocator);
        getDriver().navigate().refresh();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

}
