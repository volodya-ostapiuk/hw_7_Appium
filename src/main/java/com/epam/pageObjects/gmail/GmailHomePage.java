package com.epam.pageObjects.gmail;

import com.epam.pageObjects.BasePage;
import com.epam.utils.Wait;
import com.epam.utils.providers.DriverWaitProvider;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.StaleElementReferenceException;

public class GmailHomePage extends BasePage {

    @AndroidFindBy(id = "compose_button")
    private MobileElement composeButton;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement navigationBarButton;

    @AndroidFindBy(xpath = "//android.widget.ListView/*[6]//android.widget.TextView")
    private MobileElement sentLettersFolder;

    @AndroidFindBy(id = "selected_account_disc_gmail")
    private MobileElement selectedAccountFrame;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/*[2]")
    private MobileElement lastSentMessage;

    @AndroidFindBy(id = "action_text")
    private MobileElement cancelSentMessageLink;

    public void waitOnComposeButtonToBeClickable() {
        Wait.waitOnElementToBeClickable(composeButton);
    }

    public void clickComposeButton() {
        composeButton.click();
    }

    public String getSelectedAccountAttribute() {
        return selectedAccountFrame.getAttribute("content-desc");
    }

    public void clickOnNavigationBarButton() {
        Wait.waitOnElementToBeClickable(navigationBarButton);
        navigationBarButton.click();
    }

    public void clickSentLettersFolder() {
        DriverWaitProvider.getInstance().ignoring(StaleElementReferenceException.class).until(driver -> {
            sentLettersFolder.click();
            return true;
        });
    }

    public void clickLastSentMessage() {
        lastSentMessage.click();
    }

    public void waitOnCancelSentMessageLinkToBeClickable() {
        Wait.waitOnElementToBeClickable(cancelSentMessageLink);
    }
}
