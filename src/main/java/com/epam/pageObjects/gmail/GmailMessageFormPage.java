package com.epam.pageObjects.gmail;

import com.epam.pageObjects.BasePage;
import com.epam.utils.Wait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GmailMessageFormPage extends BasePage {

    @AndroidFindBy(id = "to")
    private MobileElement messageReceiverField;

    @AndroidFindBy(id = "subject")
    private MobileElement messageSubjectField;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View")
    private MobileElement messageContentField;

    @AndroidFindBy(id = "send")
    private MobileElement sendButton;

    public void enterReceiverEmail(String receiver) {
        waitOnElementToBeClickable(messageReceiverField);
        messageReceiverField.sendKeys(receiver + "\n");
    }

    public void enterTopic(String topic) {
        waitOnElementToBeClickable(messageSubjectField);
        messageSubjectField.sendKeys(topic + "\n");
    }

    public void enterLetterText(String letterText) {
        waitOnElementToBeClickable(messageContentField);
        messageContentField.sendKeys(letterText + "\n");
    }

    public void clickSendButton() {
        waitOnElementToBeClickable(sendButton);
        sendButton.click();
    }

    private void waitOnElementToBeClickable(MobileElement element) {
        Wait.waitOnElementToBeClickable(element);
    }
}
