package org.tmdb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{
    @FindBy(css = "#card_movie_4bc88fc1017a3c122d009254 .title h2")
    private WebElement movieTitleResult;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    //Aquí se usa PageFactory con el @FindBy
    public String getMovieSearchResult()
    {
        return movieTitleResult.getText();
    }
}
