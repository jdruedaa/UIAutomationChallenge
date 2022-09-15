package org.tmdb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
    @FindBy(css = "#main .about .content_wrapper.flex a")
    private WebElement profileUsername;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileUsername()
    {
        return profileUsername.getText();
    }
}
