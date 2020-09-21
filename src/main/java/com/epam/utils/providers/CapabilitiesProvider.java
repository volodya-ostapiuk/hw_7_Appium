package com.epam.utils.providers;

import com.epam.utils.properties.ConfigProperties;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Objects;

public class CapabilitiesProvider {
    private static DesiredCapabilities capabilities;

    private CapabilitiesProvider() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigProperties.getPlatformName());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigProperties.getDeviceName());
        capabilities.setCapability("appPackage", ConfigProperties.getAppPackage());
        capabilities.setCapability("appActivity", ConfigProperties.getAppActivity());
        //capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, ConfigProperties.getCommandTimeOut());
    }

    public static DesiredCapabilities getInstance() {
        if (Objects.isNull(capabilities)) {
            new CapabilitiesProvider();
        }
        return capabilities;
    }
}
