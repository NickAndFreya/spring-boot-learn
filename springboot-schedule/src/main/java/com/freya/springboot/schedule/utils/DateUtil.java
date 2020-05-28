package com.freya.springboot.schedule.utils;

import java.time.LocalDate;

public class DateUtil {
    private static volatile DateUtil INSTANCE;

    public String getDayOfMonth(LocalDate date) {
        int day = date.getDayOfMonth();
        if (day < 10) {
            String d = "0" + day;
            return d;
        }
        return String.valueOf(day);
    }

    public static DateUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (DateUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DateUtil();
                }
            }
        }
        return INSTANCE;
    }

    private DateUtil() {

    }
}