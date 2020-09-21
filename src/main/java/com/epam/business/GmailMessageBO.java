package com.epam.business;

import com.epam.model.MessageEntity;
import com.epam.pageObjects.gmail.GmailHomePage;
import com.epam.pageObjects.gmail.GmailMessageFormPage;
import com.epam.pageObjects.gmail.SentMessagePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GmailMessageBO {
    private GmailHomePage homePage;
    private GmailMessageFormPage messageFormPage;
    private SentMessagePage sentMessagePage;
    private static Logger logger = LogManager.getLogger(GmailMessageBO.class);

    public GmailMessageBO() {
        homePage = new GmailHomePage();
        messageFormPage = new GmailMessageFormPage();
        sentMessagePage = new SentMessagePage();
    }

    public void createAndSendMessage(MessageEntity message) {
        logger.info("Creating new message.");
        homePage.clickComposeButton();
        logger.info("Filling new message fields.");
        fillDraftMessage(message);
        logger.info("Sending created message.");
        messageFormPage.clickSendButton();
        logger.info("Waiting on sent message cancel link to be clickable.");
        homePage.waitOnCancelSentMessageLinkToBeClickable();
    }

    private void fillDraftMessage(MessageEntity message) {
        messageFormPage.enterReceiverEmail(message.getReceiver());
        messageFormPage.enterTopic(message.getTopic());
        messageFormPage.enterLetterText(message.getLetterText());
    }

    public void goToSendLettersFolderAndClickOnLastSentMessage() {
        logger.info("Going to sent messages folder.");
        homePage.clickOnNavigationBarButton();
        homePage.clickSentLettersFolder();
        logger.info("Clicking on last sent message.");
        homePage.clickLastSentMessage();
    }

    public MessageEntity getSentMessageEntity() {
        logger.info("Getting filled fields from sent message.");
        String filledToField = sentMessagePage.getFilledToFieldText();
        String filledTopicField = sentMessagePage.getFilledTopicFieldText();
        String filledTextField = sentMessagePage.getFilledLetterTextFieldText();
        logger.info("Creating new entity from sent draft message fields.");
        return new MessageEntity(filledTopicField, filledToField, filledTextField);
    }
}
