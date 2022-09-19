package org.tmdb.tests.login;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.tmdb.pages.HomePage;
import org.tmdb.pages.LogInPage;
import org.tmdb.pages.ProfilePage;
import org.tmdb.utils.Hooks;

import java.util.List;
import java.util.NoSuchElementException;

public class LogInTests extends Hooks {

    private final int numberOfErrorMessages = 3;
    @Test
    public void SuccessfulLogInTest()
    {
        HomePage home = new HomePage(driver);
        LogInPage logInPage = home.logIn();
        String username = System.getenv("MovieDB_username");
        String password = System.getenv("MovieDB_password");
        logInPage.logInToUserAccount(username, password);
        ProfilePage profilePage = new ProfilePage(driver);
        try
        {
            Assert.assertEquals(username, profilePage.getProfileUsername(), "The login attempt was " +
                    "not successful");
        }
        catch (NoSuchElementException noSuchElementException)
        {
            System.out.println("Successful Login Test Failed");
        }
    }

    @Test
    @Parameters("wrongPassword")
    public void FailedLogInWithWrongCredentialsTest(String wrongPassword)
    {
        String username = System.getenv("MovieDB_username");
        HomePage home = new HomePage(driver);
        LogInPage logInPage = home.logIn();
        logInPage.logInToUserAccount(username, wrongPassword);
        List<String> messages = logInPage.getLogInErrorMessages();
        int foundNumberOfErrorMessages = messages.size();
        Assert.assertEquals(foundNumberOfErrorMessages, numberOfErrorMessages, "There is a different number of " +
                "error messages (" + foundNumberOfErrorMessages + ") compared to the expected (" + numberOfErrorMessages
                + ")");
    }
}
