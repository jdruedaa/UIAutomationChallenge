package org.tmdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoviePage extends BasePage {

    /*@FindBy(css = ".genres")
    private WebElement movieGenres;
    */

    @FindBy(css = ".genres > [href*='28-action']")
    private WebElement actionGenre;

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public String findGenre(String genre)
    {
        WebElement targetGenre = driver.findElement(By.cssSelector(".genres > [href*="+ genre +"]"));
        return targetGenre.getText();
    }

    /*public String findGenreFromList(String genre)
    {
        WebElement targetGenre = movieGenres.findElement(By.cssSelector("[href*="+ genre +"]"));
        return targetGenre.getText();
    }*/
}
