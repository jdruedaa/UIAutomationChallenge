package org.tmdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(css = ".k-item.k-menu-item.k-state-default.k-first .no_click.k-link.k-menu-link")
    private WebElement moviesDropDownMenu;

    @FindBy(css = ".k-item.k-menu-item.k-state-default.k-last [href='/movie/top-rated']")
    private WebElement topRatedButton;

    @FindBy(css = "#popular_scroller")
    private WebElement popularMoviesScroller;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LogInPage logIn()
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.elementToBeClickable(logInButton)).click();
        return new LogInPage(driver);
    }

    public SearchResultsPage searchMovie(String movieTitle)
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        searchBar.sendKeys(movieTitle);
        explicitWait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return new SearchResultsPage(driver);
    }

    public TopRatedPage enterTopRatedMovies()
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions action = new Actions(driver);
        action.moveToElement(moviesDropDownMenu).perform();
        explicitWait.until(ExpectedConditions.elementToBeClickable(topRatedButton)).click();
        return new TopRatedPage(driver);
    }

    public MoviePage enterMovieWithActors()
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement firstPopularMoviePoster = popularMoviesScroller.findElement(By.cssSelector(".image a"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(firstPopularMoviePoster)).click();
        return new MoviePage(driver);
    }
}
