package org.tmdb.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Hooks {
    protected WebDriver driver;

    @BeforeMethod
    public void setWebDriver()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.themoviedb.org");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown()
    {
        //Este se puede comentar si se cierra muy rápido y quieres verificar algo
        driver.quit();
    }
}
