package org.tmdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LogInPage extends BasePage{
    @FindBy(css = "#login_form #username")
    private WebElement usernameTextInputField;
    @FindBy(css = "#password")
    private WebElement passwordTextInputField;
    @FindBy(css = "#login_form #login_button")
    private WebElement submitLogInFormButton;

    @FindBy(css = ".error_status.card")
    private WebElement logInErrorStatusCard;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logInToUserAccount(String username, String password)
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        usernameTextInputField.sendKeys(username);
        passwordTextInputField.sendKeys(password);
        explicitWait.until(ExpectedConditions.elementToBeClickable(submitLogInFormButton)).click();
    }

    public List<String> getLogInErrorMessages()
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        List<String> messages = new ArrayList<>();
        explicitWait.until(ExpectedConditions.visibilityOf(logInErrorStatusCard));
        WebElement mainErrorMessage = logInErrorStatusCard.findElement(By.cssSelector(".background_color"));
        System.out.println(Color.fromString(mainErrorMessage.getCssValue("background-color")).toString());
        messages.add(mainErrorMessage.getText());
        List<WebElement> providedErrorMessages = logInErrorStatusCard.findElements(By.cssSelector(".content li"));
        for(WebElement webElement:providedErrorMessages)
        {
            messages.add(webElement.getText());
        }
        return messages;
    }
}
