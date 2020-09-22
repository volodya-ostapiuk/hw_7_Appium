package com.epam.pageObjects.gmail;

import com.epam.pageObjects.BasePage;
import com.epam.utils.Wait;
import com.epam.utils.providers.DriverProvider;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GmailMessageFormPage extends BasePage {

    @AndroidFindBy(id = "to")
    private MobileElement messageReceiverField;

    @AndroidFindBy(id = "subject")
    private MobileElement messageSubjectField;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private MobileElement messageContentField;

    @AndroidFindBy(id = "send")
    private MobileElement sendButton;

    public void enterReceiverEmail(String receiver) {
        waitOnElementToBeClickable(messageReceiverField);
        messageReceiverField.sendKeys(receiver);
        DriverProvider.getInstance().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void enterTopic(String topic) {
        waitOnElementToBeClickable(messageSubjectField);
        messageSubjectField.sendKeys(topic);
        DriverProvider.getInstance().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void enterLetterText(String letterText) {
        waitOnElementToBeClickable(messageContentField);
        messageContentField.click();
        messageContentField.sendKeys(letterText);
    }

    public void clickSendButton() {
        waitOnElementToBeClickable(sendButton);
        sendButton.click();
    }

    private void waitOnElementToBeClickable(MobileElement element) {
        Wait.waitOnElementToBeClickable(element);
    }
}
