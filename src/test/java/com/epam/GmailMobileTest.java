package com.epam;

import com.epam.business.GmailLogInBO;
import com.epam.business.GmailMessageBO;
import com.epam.model.MessageEntity;
import com.epam.utils.Constants;
import com.epam.utils.providers.DriverProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailMobileTest implements Constants {

    @BeforeMethod
    private void setUp() {
        DriverProvider.getInstance();
    }

    /**
     * Enters email, enters password. Waits until new page will be opened and element will be clickable on it.
     * Checks does page contains email. Creates new letter. Sends it. Checks if last sent letter contains
     * needed email, text and topic.
     */
    @Test
    private void verifyDraftFieldsAreSavedCorrectly() {
        GmailLogInBO logInBO = new GmailLogInBO();
        logInBO.logIn(TEST_USER_EMAIL, TEST_USER_PASSWORD);
        Assert.assertTrue(logInBO.isLoggedIn(TEST_USER_EMAIL), WRONG_LOGIN);

        GmailMessageBO messageBO = new GmailMessageBO();
        messageBO.createAndSendMessage(TEST_MESSAGE);
        messageBO.goToSendLettersFolderAndClickOnLastSentMessage();

        MessageEntity lastSentMessage = messageBO.getSentMessageEntity();
        Assert.assertEquals(lastSentMessage.toString(), TEST_MESSAGE.toString(), WRONG_SENT_MESSAGE);
    }

    @AfterMethod
    private void tearDown() {
        DriverProvider.quit();
    }
}
