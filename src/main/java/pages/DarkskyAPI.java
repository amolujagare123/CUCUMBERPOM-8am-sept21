package pages;

import org.openqa.selenium.By;

public class DarkskyAPI extends  DarkSkyHome{

    By loginLink = By.xpath("//a[normalize-space()='Log In']");

    public void clickLoginLink()
    {
        clickOn(loginLink);
    }
}
