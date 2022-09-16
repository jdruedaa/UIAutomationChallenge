package org.tmdb.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks {
    protected WebDriver driver;

    @BeforeMethod
    public void setWebDriver()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.themoviedb.org");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
