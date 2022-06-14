package com.kopylov.telegrambotlogger.util;

import com.kopylov.telegrambotlogger.TelegramBotLoggerApplication;

import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readProperty(String key) {
        Properties prop = new Properties();

        try {
            prop.load(
                    TelegramBotLoggerApplication.class
                            .getClassLoader()
                            .getResourceAsStream("botlogger.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }
}
