package com.epam.utils.providers;

import com.epam.utils.properties.ConfigProperties;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Objects;

public class CapabilitiesProvider {
    private static ThreadLocal<DesiredCapabilities> capabilitiesPool = new ThreadLocal<>();

    private CapabilitiesProvider() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigProperties.getPlatformName());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigProperties.getDeviceName());
        capabilities.setCapability("appPackage", ConfigProperties.getAppPackage());
        capabilities.setCapability("appActivity", ConfigProperties.getAppActivity());
        capabilitiesPool.set(capabilities);
    }

    public static DesiredCapabilities getInstance() {
        if (Objects.isNull(capabilitiesPool.get())) {
            new CapabilitiesProvider();
        }
        return capabilitiesPool.get();
    }
}
