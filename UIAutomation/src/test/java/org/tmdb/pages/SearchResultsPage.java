package org.tmdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{
    @FindBy(css = ".search_results.movie")
    private WebElement movieSearchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String findMovieSearchResult(String titleToFind)
    {
        String targetTitle = "";
        List<WebElement> movieTitles = movieSearchResults.findElements(By.cssSelector(".title h2"));
        String currentTitle;
        for(WebElement title : movieTitles)
        {
            currentTitle = title.getText();
            if(currentTitle.equalsIgnoreCase(titleToFind))
            {
                targetTitle = currentTitle;
            }
        }
        return targetTitle;
    }
}
