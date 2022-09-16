package org.tmdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopRatedPage extends BasePage {

    @FindBy(css = ".filter_panel.card.closed [data-callback='filterCallback()']")
    private WebElement filtersButton;

    private final By actionMovieFilterButton = By.cssSelector("#with_genres [href='/discover/movie?with_genres=28']");

    private final By filterSectionSearchButton = By.cssSelector(".apply.small.background_color .no_click.load_more");

    private final By firstMoviePosterButton = By.cssSelector("#page_1 .poster");

    public TopRatedPage(WebDriver driver) {
        super(driver);
    }

    public MoviePage filterMoviesByActionGenre() throws InterruptedException {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.elementToBeClickable(filtersButton)).click();
        Actions action = new Actions(driver);
        WebElement actionMovieFilterButtonWE = driver.findElement(actionMovieFilterButton);
        action.scrollToElement(actionMovieFilterButtonWE).perform();
        explicitWait.until(ExpectedConditions.elementToBeClickable(actionMovieFilterButtonWE)).click();
        WebElement filterSectionSearchButtonWE = driver.findElement(filterSectionSearchButton);
        action.scrollToElement(filterSectionSearchButtonWE).perform();
        action.scrollByAmount(0,1).perform();
        explicitWait.until(ExpectedConditions.elementToBeClickable(filterSectionSearchButtonWE)).click();
        WebElement firstMoviePosterButtonWE = driver.findElement(firstMoviePosterButton);
        explicitWait.until(ExpectedConditions.stalenessOf(firstMoviePosterButtonWE));
        firstMoviePosterButtonWE = driver.findElement(firstMoviePosterButton);
        explicitWait.until(ExpectedConditions.elementToBeClickable(firstMoviePosterButtonWE)).click();
        return new MoviePage(driver);
    }
}
