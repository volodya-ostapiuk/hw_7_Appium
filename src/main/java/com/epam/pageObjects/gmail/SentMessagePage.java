package com.epam.pageObjects.gmail;

import com.epam.pageObjects.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SentMessagePage extends BasePage {

    @AndroidFindBy(id = "subject_and_folder_view")
    private MobileElement messageSubjectText;

    @AndroidFindBy(id = "recipient_summary")
    private MobileElement messageReceiverText;

    @AndroidFindBy(xpath = "//android.view.View[2]/*")
    private MobileElement messageContentText;

    public String getFilledToFieldText() {
        return messageReceiverText.getText();
    }

    public String getFilledTopicFieldText() {
        return messageSubjectText.getText();
    }

    public String getFilledLetterTextFieldText() {
        return messageContentText.getText();
    }
}
