package org.tmdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActorProfilePage extends BasePage{
    @FindBy(css = "#media_v4 .title h2 a")
    private WebElement actorName;

    @FindBy(css = "#media_v4")
    private WebElement actingTimeLine;

    public ActorProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getActorName()
    {
        return actorName.getText();
    }

    public String findMovieInTimeline(String movieTitle) {
        String targetMovieTitle = "";
        List<WebElement> actingTimelineMovieTitles = actingTimeLine.findElements(By.cssSelector(".tooltip bdi"));
        List<WebElement> actingTimelineMovieYears = actingTimeLine.findElements(By.cssSelector(".year"));
        String title;
        String releaseYear;
        String titleAndReleaseYear;
        for(int i = 0; i < actingTimelineMovieTitles.size(); i++) {
            title = actingTimelineMovieTitles.get(i).getText();
            releaseYear = actingTimelineMovieYears.get(i).getText();
            if(releaseYear.equals("—"))
            {
                titleAndReleaseYear = title;
            }
            else
            {
                titleAndReleaseYear = actingTimelineMovieTitles.get(i).getText() + " (" + actingTimelineMovieYears.get(i).getText() + ")";
            }
            if (titleAndReleaseYear.equals(movieTitle)) {
                targetMovieTitle = titleAndReleaseYear;
                break;
            }
        }
        return targetMovieTitle;
    }
}
