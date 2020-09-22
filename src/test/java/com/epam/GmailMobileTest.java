package com.epam;

import com.epam.business.GmailLogInBO;
import com.epam.business.GmailMessageBO;
import com.epam.listeners.TestListener;
import com.epam.model.MessageEntity;
import com.epam.utils.Constants;
import com.epam.utils.providers.DriverProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class GmailMobileTest implements Constants {
    GmailLogInBO logInBO;
    GmailMessageBO messageBO;

    @BeforeMethod
    private void setUp() {
        DriverProvider.getInstance();
        logInBO = new GmailLogInBO();
        messageBO = new GmailMessageBO();
    }

    /**
     * Enters email, enters password. Waits until new page will be opened and element will be clickable on it.
     * Checks does page contains email. Creates new letter. Sends it. Checks if last sent letter contains
     * needed email, text and topic.
     */
    @Test
    @Description("Login, create draft message, verify draft fields are saved correctly and send draft message.")
    private void verifyDraftFieldsAreSavedCorrectly() {
        logInBO.logIn(TEST_USER_EMAIL, TEST_USER_PASSWORD);
        Assert.assertTrue(logInBO.isLoggedIn(TEST_USER_EMAIL), WRONG_LOGIN);

        messageBO.createAndSendMessage(TEST_MESSAGE);
        messageBO.goToSendLettersFolderAndClickOnLastSentMessage();

        MessageEntity lastSentMessage = messageBO.getSentMessageEntity();
        Assert.assertTrue(lastSentMessage.getReceiver().contains(TEST_RECEIVER), WRONG_SENT_RECEIVER);
        Assert.assertTrue(lastSentMessage.getTopic().contains(TEST_TOPIC), WRONG_SENT_TOPIC);
        Assert.assertTrue(lastSentMessage.getLetterText().contains(TEST_LETTER_TEXT), WRONG_SENT_TEXT);
    }

    @AfterMethod
    private void tearDown() {
        DriverProvider.quit();
    }
}
