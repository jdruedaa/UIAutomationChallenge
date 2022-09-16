package org.tmdb.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tmdb.pages.HomePage;
import org.tmdb.pages.LogInPage;
import org.tmdb.pages.ProfilePage;
import org.tmdb.utils.Hooks;

import java.util.NoSuchElementException;

public class LogInTests extends Hooks {

    //Mirar Listeners de testng para cosas como screenshots. Y dataproviders, especialmente para data-driven frameworks

    @Test
    //@Parameters({"correctUsername", "correctPassword"})
    //public void SuccessfulLogInTest(String username, String password)
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
            System.out.println("Successful Login Test Failed");;
        }
    }

    /*
    @Test
    @Parameters({"correctUsername", "wrongPassword"})
    public void FailedLogInWithWrongCredentialsTest(String correctUsername, String wrongPassword)
    {
        HomePage home = new HomePage(driver);
        LogInPage logInPage = home.logIn();
        logInPage.logInToUserAccount(correctUsername, wrongPassword);
        try
        {

        }
        catch (NoSuchElementException noSuchElementException)
        {
            System.out.println("Failed Login with Wrong Credentials Test Failed");
        }
    }
    */
}
