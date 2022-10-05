package org.tmdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class TopRatedPage extends BasePage {

    @FindBy(css = ".filter_panel.card.closed [data-callback='filterCallback()']")
    private WebElement filtersButton;

    @FindBy(css = ".filter [aria-owns='sort_by_listbox']")
    private WebElement sortDropdownMenu;

    @FindBy(css = "#media_results")
    private WebElement movieResults;

    private final By actionMovieFilterButton = By.cssSelector("#with_genres [href='/discover/movie?with_genres=28']");

    private final By searchButton = By.cssSelector(".apply.small.background_color .no_click.load_more");

    private final By firstMoviePosterButton = By.cssSelector("#page_1 .poster");

    //private final By sortMoviesReleaseDateAscendingButton = By.cssSelector("#sort_by [value='primary_release_date.asc']");

    private final By sortMoviesReleaseDateAscendingButton = By.xpath("//ul/li[contains(text(),'Release Date Ascending')]");

    public TopRatedPage(WebDriver driver) {
        super(driver);
    }

    public MoviePage filterMoviesByActionGenre(){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.elementToBeClickable(filtersButton)).click();
        Actions action = new Actions(driver);
        WebElement actionMovieFilterButtonWE = driver.findElement(actionMovieFilterButton);
        action.scrollToElement(actionMovieFilterButtonWE).perform();
        explicitWait.until(ExpectedConditions.elementToBeClickable(actionMovieFilterButtonWE)).click();
        WebElement filterSectionSearchButtonWE = driver.findElement(searchButton);
        action.scrollToElement(filterSectionSearchButtonWE).perform();
        action.scrollByAmount(0,1).perform();
        explicitWait.until(ExpectedConditions.elementToBeClickable(filterSectionSearchButtonWE)).click();
        WebElement firstMoviePosterButtonWE = driver.findElement(firstMoviePosterButton);
        explicitWait.until(ExpectedConditions.stalenessOf(firstMoviePosterButtonWE));
        firstMoviePosterButtonWE = driver.findElement(firstMoviePosterButton);
        explicitWait.until(ExpectedConditions.elementToBeClickable(firstMoviePosterButtonWE)).click();
        return new MoviePage(driver);
    }

    public void sortMoviesByDateAscending()
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.elementToBeClickable(sortDropdownMenu)).click();
        explicitWait.until(ExpectedConditions.elementToBeClickable(sortMoviesReleaseDateAscendingButton)).click();
        explicitWait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        WebElement firstMoviePosterButtonWE = driver.findElement(firstMoviePosterButton);
        explicitWait.until(ExpectedConditions.stalenessOf(firstMoviePosterButtonWE));
    }

    public Date[] getSortedMoviesDates(int numberOfMovies) throws ParseException {
        Date[] dates = new Date[numberOfMovies];
        List<WebElement> releaseDates = movieResults.findElements(By.cssSelector("p"));
        int counter = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
        for(WebElement dateWebElement:releaseDates)
        {
            dates[counter] = simpleDateFormat.parse(dateWebElement.getText());
            if(counter == numberOfMovies-1)
            {
                break;
            }
            counter++;
        }
        return dates;
    }
}
