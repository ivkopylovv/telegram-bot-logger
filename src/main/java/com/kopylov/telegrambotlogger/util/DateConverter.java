package com.kopylov.telegrambotlogger.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    private static final String COMMAND_DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    public static Date convertIntToDate(int messageDate) {
        return new Date(Long.valueOf(messageDate) * 1000);
    }

    public static String convertDateToString(Date date) {
        return date.toString().substring(0, 19);
    }

    public static Date convertStringToDate(String date) throws ParseException {
        return new SimpleDateFormat(COMMAND_DATE_FORMAT).parse(date);
    }
}
