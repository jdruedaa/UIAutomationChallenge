package org.tmdb.tests.search;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.tmdb.pages.HomePage;
import org.tmdb.pages.SearchResultsPage;
import org.tmdb.utils.Hooks;

public class SearchTests extends Hooks {

    @Test
    @Parameters("movieTitle")
    public void SearchMovieByTitleTest(String movieTitle)
    {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchMovie(movieTitle); //parameter from xml movie title
        Assert.assertTrue(searchResultsPage.getMovieSearchResult().equals(movieTitle), "The movie that was " +
                "searched for: " + movieTitle + ". doesn't match the search result.");
    }
}
