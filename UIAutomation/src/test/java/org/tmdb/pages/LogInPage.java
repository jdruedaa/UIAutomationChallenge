package org.tmdb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage extends BasePage{
    @FindBy(css = "#login_form #username")
    private WebElement usernameTextInputField;
    @FindBy(css = "#password")
    private WebElement passwordTextInputField;
    @FindBy(css = "#login_form #login_button")
    private WebElement submitLogInFormButton;

    @FindBy(css = ".error_status.card .open.no_click")
    private WebElement logInErrorStatusCard;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logInToUserAccount(String username, String password)
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        usernameTextInputField.sendKeys(username);
        passwordTextInputField.sendKeys(password);
        explicitWait.until(ExpectedConditions.elementToBeClickable(submitLogInFormButton)).click();
    }
}
