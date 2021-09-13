package pages;

import org.openqa.selenium.By;

public class Login extends  DarkskyAPI{

    By loginButton = By.xpath("//button[@type='submit']");

    public void clickLoginButton()
    {
        clickOn(loginButton);
    }

}
