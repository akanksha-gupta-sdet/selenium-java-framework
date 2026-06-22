package com.akanksha.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {

        properties = new Properties();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");

            if (inputStream == null) {
                throw new RuntimeException("config.properties not found");
            }

            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load config.properties", e);
        }
    }

    public String getProperty(String key) {

        return properties.getProperty(key);
    }
}