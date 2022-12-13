package com.ultimateqa.courses.pages;

import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SignInPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInButton;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Invalid email or password.')]")
    WebElement invalidText;

    public String getWelcomeText() {
        Reporter.log("Get welcome text" + welcomeText.toString());
        return getTextFromElement(welcomeText);
    }

    public void enterEmailId(String text) {
        Reporter.log("Enter email id" + emailField.toString());
        sendTextToElement(emailField, text);
    }

    public void enterPassword(String text) {
        Reporter.log("Enter password field" + passwordField.toString());
        sendTextToElement(passwordField, text);
    }

    public void clickOnSignInButton() {
        Reporter.log("Click on sign in button" + signInButton.toString());
        clickOnElement(signInButton);
    }

    public String getInvalidText() {
        Reporter.log("Get invalid text" + invalidText.toString());
        return getTextFromElement(invalidText);
    }
}
