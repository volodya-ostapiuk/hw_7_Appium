package com.epam.pageObjects.gmail;

import com.epam.pageObjects.BasePage;
import com.epam.utils.Wait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Google']")
    private MobileElement googleSetupLink;

    @AndroidFindBy(id = "identifierId")
    private MobileElement emailInput;

    @AndroidFindBy(id = "profileIdentifier")
    private MobileElement profileIdentifier;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement passwordInput;

    @AndroidFindBy(id = "signinconsentNext")
    private MobileElement signInNextButton;

    public void setupViaGoogle() {
        waitOnElementToBeClickable(googleSetupLink);
        googleSetupLink.click();
    }

    public void enterEmail(String email) {
        waitOnElementToBeClickable(emailInput);
        emailInput.sendKeys(email + "\n");
    }

    public void enterPassword(String password) {
        waitOnElementToBeClickable(passwordInput);
        passwordInput.sendKeys(password + "\n");
    }

    public String getProfileIdentifierText() {
        return profileIdentifier.getText();
    }

    public void clickSignInNextButton() {
        waitOnElementToBeClickable(signInNextButton);
        signInNextButton.click();
    }

    private void waitOnElementToBeClickable(MobileElement element) {
        Wait.waitOnElementToBeClickable(element);
    }
}
