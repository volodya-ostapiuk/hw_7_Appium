package com.epam.business;

import com.epam.pageObjects.gmail.GmailHomePage;
import com.epam.pageObjects.gmail.LoginPage;
import com.epam.pageObjects.gmail.WelcomePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GmailLogInBO {
    private WelcomePage welcomePage;
    private LoginPage loginPage;
    private GmailHomePage homePage;
    private static Logger logger = LogManager.getLogger(GmailLogInBO.class);

    public GmailLogInBO() {
        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
        homePage = new GmailHomePage();
    }

    @Step("Authorise user with email: {0}, password: {1}, in {method} step")
    public void logIn(String userEmail, String userPassword) {
        logger.info("Authorising user: " + userEmail);
        welcomePage.clickOnGotItButton();
        if (!welcomePage.isEmailAuthorised(userEmail)) {
            logger.info("Adding another user");
            welcomePage.addAnotherEmail();
            loginPage.setupViaGoogle();
            logger.info("Authorising user with email: " + userEmail);
            loginPage.enterEmail(userEmail);
            logger.info("Authorising user with password: " + userPassword);
            loginPage.enterPassword(userPassword);
            loginPage.clickSignInNextButton();
        }
        logger.info("Entering Gmail page");
        welcomePage.clickOnGoToGmailButton();
    }

    @Step("Verify user with email: {0} is logged in successfully, in {method} step")
    public boolean isLoggedIn(String userEmail) {
        logger.info("Verifying user " + userEmail + " is logged in successfully");
        homePage.waitOnComposeButtonToBeClickable();
        return homePage.getSelectedAccountAttribute().toLowerCase().contains(userEmail.toLowerCase());
    }
}
