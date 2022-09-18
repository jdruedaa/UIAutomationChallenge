package org.tmdb.tests.toprated;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.tmdb.pages.HomePage;
import org.tmdb.pages.MoviePage;
import org.tmdb.pages.TopRatedPage;
import org.tmdb.utils.Hooks;

public class TopRatedTests extends Hooks {

    @Test
    @Parameters("filterGenre")
    public void FilterTopRatedMoviesByGenreTest(String filterGenre)
    {
        HomePage homePage = new HomePage(driver);
        TopRatedPage topRatedPage = homePage.enterTopRatedMovies();
        MoviePage moviePage;
        try {
            moviePage = topRatedPage.filterMoviesByActionGenre();
            Assert.assertTrue(moviePage.findGenre(filterGenre).equalsIgnoreCase(filterGenre), "The genre filter " + filterGenre +
                    " isn't working properly in Top Movies.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
