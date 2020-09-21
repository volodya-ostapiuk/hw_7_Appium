package com.epam.pageObjects.gmail;

import com.epam.pageObjects.BasePage;
import com.epam.utils.Constants;
import com.epam.utils.Wait;
import com.epam.utils.providers.DriverProvider;
import com.epam.utils.providers.DriverWaitProvider;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailHomePage extends BasePage {

    @AndroidFindBy(id = "compose_button")
    private MobileElement composeButton;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement navigationBarButton;

    @AndroidFindBy(id = "conversation_list_folder_header")
    private MobileElement searchHeader;

    @AndroidFindBy(id = "open_search_view_edit_text")
    private MobileElement searchField;

    @AndroidFindBy(xpath = "//android.widget.ListView/*[6]//android.widget.TextView")
    private MobileElement sentLettersFolder;

    @AndroidFindBy(id = "selected_account_disc_gmail")
    private MobileElement selectedAccountFrame;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]")
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
        searchHeader.click();
        searchField.sendKeys(Constants.IN_SENT_TEXT);
        DriverProvider.getInstance().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickLastSentMessage() {
        lastSentMessage.click();
    }

    public void waitOnCancelSentMessageLinkToBeClickable() {
        Wait.waitOnElementToBeClickable(cancelSentMessageLink);
    }

    public void waitOnCancelSentMessageLinkToBeInvisible() {
        DriverWaitProvider.getInstance().until(ExpectedConditions.invisibilityOf(cancelSentMessageLink));
    }
}
