package org.tmdb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(css = ".primary [href='/login']")
    private WebElement logInButton;

    @FindBy(css = "#inner_search_v4")
    private WebElement searchBar;

    @FindBy(css = "#inner_search_form [type='submit']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LogInPage logIn()
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.elementToBeClickable(logInButton)).click();
        return new LogInPage(driver);
    }

    public SearchResultsPage searchMovie(String movieTitle)
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        searchBar.sendKeys(movieTitle);
        explicitWait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return new SearchResultsPage(driver);
    }
}
