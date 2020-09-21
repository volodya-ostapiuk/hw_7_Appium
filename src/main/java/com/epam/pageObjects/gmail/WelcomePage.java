package com.epam.pageObjects.gmail;

import com.epam.pageObjects.BasePage;
import com.epam.utils.Wait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class WelcomePage extends BasePage {

    @AndroidFindBy(id = "welcome_tour_got_it")
    private MobileElement gotItButton;

    @AndroidFindBy(id = "setup_addresses_list")
    private MobileElement authorisedAccountsLayer;

    @AndroidFindBy(id = "account_address")
    private List<MobileElement> authorisedUserAccounts;

    @AndroidFindBy(id = "setup_addresses_add_another")
    private MobileElement addAnotherEmailLink;

    @AndroidFindBy(id = "action_done")
    private MobileElement goToGmailButton;

    public void clickOnGotItButton() {
        waitOnElementToBeClickable(gotItButton);
        gotItButton.click();
    }

    public void addAnotherEmail() {
        waitOnElementToBeClickable(addAnotherEmailLink);
        addAnotherEmailLink.click();
    }

    public boolean isEmailAuthorised(String userEmail) {
        Wait.waitOnElementToBeVisible(authorisedAccountsLayer);
        return authorisedUserAccounts.stream().anyMatch(account -> account.getText().contains(userEmail.toLowerCase()));
    }

    public void clickOnGoToGmailButton() {
        waitOnElementToBeClickable(goToGmailButton);
        goToGmailButton.click();
    }

    private void waitOnElementToBeClickable(MobileElement element) {
        Wait.waitOnElementToBeClickable(element);
    }
}
