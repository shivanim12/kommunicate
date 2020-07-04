package com.kommunicate.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {
    public static String getPropertyValue(String key) throws IOException {
        InputStream fis = FileUtils.class.getClassLoader().getResourceAsStream("./config.properties");
        Properties properties = new Properties();
        properties.load(fis);
        return properties.getProperty(key, "");
    }
}
