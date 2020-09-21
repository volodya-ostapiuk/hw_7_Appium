package com.epam.pageObjects;

import com.epam.utils.providers.DriverProvider;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected AndroidDriver<MobileElement> webDriver;

    public BasePage() {
        webDriver = DriverProvider.getInstance();
        PageFactory.initElements(new AppiumFieldDecorator(webDriver), this);
    }
}
