package org.tmdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MoviePage extends BasePage {

    /*@FindBy(css = ".genres")
    private WebElement movieGenres;
    */

    @FindBy(css = ".genres")
    private WebElement movieGenres;

    @FindBy(css = "#cast_scroller .profile")
    private WebElement firstActor;

    @FindBy(css = ".title.ott_true h2")
    private WebElement movieTitle;

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public String findGenre(String genreToFind)
    {
        String targetGenre = "";
        List<WebElement> genres = movieGenres.findElements(By.cssSelector("a"));
        String currentGenre;
        for(WebElement genre : genres)
        {
            currentGenre = genre.getText();
            if(currentGenre.equalsIgnoreCase(genreToFind))
            {
                targetGenre = currentGenre;
            }
        }
        return targetGenre;
    }

    /*public String findGenreFromList(String genre)
    {
        WebElement targetGenre = movieGenres.findElement(By.cssSelector("[href*="+ genre +"]"));
        return targetGenre.getText();
    }*/

    public ActorProfilePage enterActorProfilePage()
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.elementToBeClickable(firstActor)).click();
        return new ActorProfilePage(driver);
    }

    public String getMovieTitle()
    {
        return movieTitle.getText();
    }
}
