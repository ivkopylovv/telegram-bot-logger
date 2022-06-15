package com.kopylov.telegrambotlogger.util;

import java.util.Date;

public class DateHelper {

    public static Date getMessageDate(int messageDate) {
        return new Date(Long.valueOf(messageDate) * 1000);
    }

    public static String convertDateToString(Date date) {
        return date.toString().substring(0, 19);
    }
}
