package com.freya.nc.common.ncutil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间相关工具
 *
 * @author chengpiny
 */
public class TimeUtil {
    private static Calendar calendar = Calendar.getInstance();

    public static int getTimeDims() {
        calendar.setTime(new Date());
        int daysOfMonth = calendar.getActualMaximum(Calendar.DATE);
        int timeDims = daysOfMonth * 24;
        return timeDims;
    }

    public static int getMonth() {
        calendar.setTime(new Date());
        int month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    public static int getYear() {
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    public static int getTimeLevel() {
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Date date = calendar.getTime();
        SimpleDateFormat f = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(f.format(date));
        int timeLevel = (day - 1) * 24 + hour;
        return timeLevel;
    }

    public static String getTimeUnit() {
        String timeUnit = getMonth() < 10 ? "hour since " + getYear() + "-0" + getMonth() + "-01 00:00:00" : "hours since " +
                getYear() + "-" + getMonth() + "-01 00:00:00";
        return timeUnit;
    }

    public static String getMonthWithYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String res = sdf.format(new Date());
        return res;
    }

    public static boolean isLeapYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(sdf.format(new Date()));
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        }
        return false;
    }

}
