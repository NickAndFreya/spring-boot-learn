package com.freya.springboot.schedule.utils;

import java.time.LocalDate;

public class DateUtil {
    private static LocalDate date = LocalDate.now();

    public static String getDayOfMonth() {
        int day = date.getDayOfMonth();
        if (day < 10) {
            String d = "0" + day;
            return d;
        }
        return String.valueOf(day);
    }
}