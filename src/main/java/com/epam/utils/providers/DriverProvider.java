package com.epam.utils.providers;

import com.epam.utils.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverProvider implements Constants {
    private static AndroidDriver<MobileElement> driver;
    private static URL url;

    static {
        try {
            url = new URL(BASE_URL);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }

    private DriverProvider() {
        driver = new AndroidDriver<>(url, CapabilitiesProvider.getInstance());
        driver.manage()
                .timeouts()
                .implicitlyWait(TIME_WAIT, TimeUnit.SECONDS);
    }

    public static AndroidDriver<MobileElement> getInstance() {
        if (Objects.isNull(driver)) {
            new DriverProvider();
        }
        return driver;
    }

    public static void quit() {
        if (Objects.nonNull(driver)) {
            driver.quit();
        }
    }
}
