package org.tmdb.tests.actingtimeline;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tmdb.pages.ActorProfilePage;
import org.tmdb.pages.HomePage;
import org.tmdb.pages.MoviePage;
import org.tmdb.utils.Hooks;

public class ActingTimelineTests extends Hooks {

    @Test
    public void VerifyActingTimelineConsistencyTest()
    {
        HomePage homePage = new HomePage(driver);
        MoviePage moviePage = homePage.enterMovieWithActors();
        String movieTitle = moviePage.getMovieTitle();
        ActorProfilePage actorProfilePage = moviePage.enterActorProfilePage();
        Assert.assertEquals(actorProfilePage.findMovieInTimeline(movieTitle), movieTitle, "The acting timeline for the" +
                " actor " + actorProfilePage.getActorName() + " isn't consistent with the movie " + movieTitle + ".");
    }
}
