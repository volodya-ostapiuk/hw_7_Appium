package com.epam.utils.providers;

import com.epam.utils.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverProvider implements Constants {
    private static ThreadLocal<AndroidDriver<MobileElement>> driverPool = new ThreadLocal<>();
    private static URL url;

    static {
        try {
            url = new URL(BASE_URL);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }

    private DriverProvider() {
        driverPool.set(new AndroidDriver<>(url, CapabilitiesProvider.getInstance()));
        driverPool.get().manage()
                .timeouts()
                .implicitlyWait(TIME_WAIT, TimeUnit.SECONDS);
    }

    public static synchronized AndroidDriver<MobileElement> getInstance() {
        if (Objects.isNull(driverPool.get())) {
            new DriverProvider();
        }
        return driverPool.get();
    }

    public static void quit() {
        if (Objects.nonNull(driverPool.get())) {
            driverPool.get().quit();
            driverPool.set(null);
        }
    }
}
