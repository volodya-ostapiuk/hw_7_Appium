package com.epam.utils.properties;

import java.util.Objects;

import static com.epam.utils.properties.PropertySource.getProperty;

public class ConfigProperties {

    public static String getBaseUrl() {
        return getProperty("base_url");
    }

    public static int getTimeWait() {
        return Integer.parseInt(Objects.requireNonNull(getProperty("time_wait")));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(Objects.requireNonNull(getProperty("explicit_wait")));
    }

    public static String getDataSource() {
        return getProperty("data_source");
    }

    public static String getDeviceName() {
        return getProperty("device_name");
    }

    public static String getPlatformName() {
        return getProperty("platform_name");
    }

    public static String getAppPackage() {
        return getProperty("app_package");
    }

    public static String getAppActivity() {
        return getProperty("app_activity");
    }

    public static String getCommandTimeOut() {
        return getProperty("command_time_out");
    }
}
