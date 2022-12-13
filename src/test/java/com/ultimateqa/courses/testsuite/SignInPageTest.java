package com.ultimateqa.courses.testsuite;

import com.ultimateqa.courses.pages.HomePage;
import com.ultimateqa.courses.pages.SignInPage;
import com.ultimateqa.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInPageTest extends BaseTest {
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        homePage = new HomePage();
        signInPage = new SignInPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnSignIn();
        String expectedText = "Welcome Back!";
        Assert.assertEquals(signInPage.getWelcomeText(), expectedText, "Welcome back text is not coming");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessage() {
        homePage.clickOnSignIn();
        signInPage.enterEmailId("xyz@gmail.com");
        signInPage.enterPassword("xyz123");
        signInPage.clickOnSignInButton();
        String expectedText = "Invalid email or password.";
        Assert.assertEquals(signInPage.getInvalidText(), expectedText, "Invalid email or password is not displayed");
    }
}

