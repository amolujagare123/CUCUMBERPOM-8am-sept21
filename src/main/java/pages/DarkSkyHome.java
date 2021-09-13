package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

import static stepDefinition.SharedSD.getDriver;

public class DarkSkyHome extends Base{

    By currentTemp = By.xpath("//span[@class='summary swap']");
    // it represents the text "85˚ Humid and Mostly Cloudy."
    By timelineTemp = By.xpath("//span[@class='first']/span");
    // it represents the text "85°"
    By timelist = By.xpath("//span[@class='hour']/span");

    By expander = By.xpath("//a[@data-day='0']//span[@class='toggle']");
    By barMinTemp = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    By barMaxTemp = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");
    By timelineHighTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");
    By timelineLowTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");

    By darkskyAPI = By.xpath("//a[normalize-space()='Dark Sky API']");

    public void clickDarkSkyAPI()
    {
        clickOn(darkskyAPI);
    }

    public ArrayList<String> getBarTempList()
    {
        String minTemp = getTextFromElement(barMinTemp).split("˚")[0];
        String maxTemp = getTextFromElement(barMaxTemp).split("˚")[0];
        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(minTemp);
        tempList.add(maxTemp);
        return tempList;
    }

    public ArrayList<String> getTimeLineTempList()
    {
        String minTemp = getTextFromElement(timelineLowTemp).split("˚")[0];
        String maxTemp = getTextFromElement(timelineHighTemp).split("˚")[0];
        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(minTemp);
        tempList.add(maxTemp);
        return tempList;
    }


    public void clickExpander()
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript("window.scrollBy(0,800)"); // scroll

        js.executeScript("arguments[0].click()",webAction(expander)); // click


    }


    public ArrayList<Integer> getTimeList()
    {
       ArrayList<String> timeListStr =  getElementTextList(timelist);
        System.out.println(timeListStr);
        //[10am, 12pm, 2pm, 4pm, 6pm, 8pm, 10pm, 12am, 2am, 4am, 6am]
        ArrayList<Integer> timelistInt = new ArrayList<>();
        for(int i=0;i<timeListStr.size();i++)
        {
            String timeRowStr = timeListStr.get(i); // "10am"
            int l = timeRowStr.length();
          //  System.out.println(timeRowStr.substring(0,l-2));
            int time =  Integer.parseInt(timeRowStr.substring(0,l-2));
            timelistInt.add(time);
        }
        System.out.println(timelistInt);
        return timelistInt;
    }


    public int getCurrentTemp()
    {
        String currTempRowStr = getTextFromElement(currentTemp);
        //"85˚ Humid and Mostly Cloudy."
        String tempStr = currTempRowStr.split("˚")[0]; //"85"
        return  Integer.parseInt(tempStr);
    }

    public int getTimelineTemp()
    {
        String currTempRowStr = getTextFromElement(timelineTemp);
        //"85˚ Humid and Mostly Cloudy."
        String tempStr = currTempRowStr.split("°")[0]; //"85"
        return  Integer.parseInt(tempStr);
    }


}
