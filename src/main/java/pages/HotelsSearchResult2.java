package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchResult2 extends  Base{
    
    By distText = By.xpath("//li[contains(text(),'km to city centre')]");
    
    public ArrayList<Double> getDistList()
    {
        ArrayList<String> elementList = getElementTextList(distText);
        // 7.2 km to city centre
        ArrayList<Double> distList = new ArrayList<>();

        for(int i=0;i<elementList.size();i++)
        {
            System.out.println(elementList.get(i));

            String distStr = elementList.get(i).split(" ")[0];

            double dist = Double.parseDouble(distStr);

            distList.add(dist);
        }
        return distList;
    }
    
}
