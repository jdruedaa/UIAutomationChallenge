package org.tmdb.tests.toprated;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.tmdb.pages.HomePage;
import org.tmdb.pages.MoviePage;
import org.tmdb.pages.TopRatedPage;
import org.tmdb.utils.Hooks;

import java.text.ParseException;
import java.util.Date;

public class TopRatedTests extends Hooks {

    private final int numberOfMovieDates = 4;

    @Test
    @Parameters("filterGenre")
    public void FilterTopRatedMoviesByGenreTest(String filterGenre)
    {
        HomePage homePage = new HomePage(driver);
        TopRatedPage topRatedPage = homePage.enterTopRatedMovies();
        MoviePage moviePage;
        moviePage = topRatedPage.filterMoviesByActionGenre();
        Assert.assertTrue(moviePage.findGenre(filterGenre).equalsIgnoreCase(filterGenre), "The genre filter " + filterGenre +
                    " isn't working properly in Top Movies.");
    }

    @Test
    public void SortTopRatedMoviesByReleaseDateAscending()
    {
        HomePage homePage = new HomePage(driver);
        TopRatedPage topRatedPage = homePage.enterTopRatedMovies();
        topRatedPage.sortMoviesByDateAscending();
        Date[] dates;
        try {
            dates = topRatedPage.getSortedMoviesDates(numberOfMovieDates);
            int counter = 1;
            Date previousDate = dates[0];
            Date currentDate;
            while(counter < dates.length)
            {
                currentDate = dates[counter];
                Assert.assertTrue(currentDate.after(previousDate),"The Top Movies weren't sorted correctly by release date," +
                        "ascending.");
                previousDate = currentDate;
                counter++;
            }
        } catch (ParseException e) {
            System.out.println("The movie dates in Top Movies weren't provided in the correct format.");
        }
    }
}
