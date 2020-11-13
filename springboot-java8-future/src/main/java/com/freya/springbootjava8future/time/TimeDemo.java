package com.freya.springbootjava8future.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Version 0.0.1
 * @Description TimeDemo
 * @Date 2020-11-11 12:22
 * @Author Cheng Pin.Y & Nick
 */
public class TimeDemo {
    public static void main(String[] args) {
        /*getCurrentDate();
        getDetailDate();
        handleSpecialDate();
        cycleDate();
        getCurrentTime();*/
        clock();
        getZoneTime();
        isLeapYear();
        checkCardExpiry();
    }

    /**
     * 获取今天的日期
     */
    public static void getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Today's Local Date:" + localDate);

        //对比
        Date date = new Date();
        System.out.println(date);
    }

    /**
     * 获取年 月 日 信息
     */
    public static void getDetailDate() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.printf("Year : %d  Month : %d  day : %d %n", year, month, day);
    }

    /**
     * 处理特定日期
     */
    public static void handleSpecialDate() {
        LocalDate dateOfBirth = LocalDate.of(2020, 11, 11);
        System.out.println("The special date is : " + dateOfBirth);
    }

    /**
     * 判断两个日期是否相等
     */
    public static void compareDate() {
        LocalDate today = LocalDate.now();
        LocalDate date1 = LocalDate.of(2020, 11, 11);

        if (date1.equals(today)) {
            System.out.printf("TODAY %s and DATE1 %s are same date %n", today, date1);
        }
    }

    /**
     * 处理周期性的日期
     */

    public static void cycleDate() {
        LocalDate dateOfBirth = LocalDate.of(1988, 12, 14);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());

        LocalDate today = LocalDate.now();
        MonthDay currentMonthDay = MonthDay.from(today);

        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }

        YearMonth yearMonthOfBirth = YearMonth.of(1988, 12);
        YearMonth yearMonth = YearMonth.of(today.getYear(), today.getMonth());
        if (yearMonthOfBirth.equals(yearMonth)) {
            System.out.println("hello!");
        }
    }

    /**
     * 获取当前时间  默认输出格式为：HH:mm:ss:nnn
     */
    public static void getCurrentTime() {
        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);
    }

    /**
     * 增加小时
     * 注意，这些方法返回一个全新的LocalTime实例，由于其不可变性，返回后一定要用变量赋值。
     */
    public static void plusHours() {
        LocalTime time = LocalTime.now();
        // 增加两小时
        LocalTime newTime = time.plusHours(2);
        System.out.println("Time after 2 hours : " + newTime);
    }

    /**
     * 如何计算一周后的日期
     * LocalDate日期不包含时间信息，它的plus()方法用来增加天、周、月，ChronoUnit类声明了这些时间单位。
     * 由于LocalDate也是不变类型，返回后一定要用变量赋值。
     * <p>
     * 可以用同样的方法增加1个月、1年、1小时、1分钟甚至一个世纪，更多选项可以查看Java 8 API中的ChronoUnit类。
     */
    public static void nextWeek() {
        LocalDate today = LocalDate.now();
        //使用变量赋值
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);
    }

    /**
     * 计算一年前或一年后的日期
     */
    public static void minusDate() {
        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("Date before 1 year : " + previousYear);

        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Date after 1 year : " + nextYear);
    }

    /**
     * Java 8增加了一个 Clock 时钟类用于获取当时的时间戳，或当前时区下的日期时间信息。
     * 以前用到System.currentTimeInMillis() 和 TimeZone.getDefault() 的地方都可用Clock替换。
     */
    public static void clock() {
        // 根据系统时间返回当前时间并设置为UTC。
        Clock clock = Clock.systemUTC();
        System.out.println("Clock :" + clock);

        // 根据系统时钟区域返回时间
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock :" + clock);
    }

    /**
     * 如何用Java判断日期是早于还是晚于另一个日期
     */
    public static void isBeforeOrIsAfter() {
        LocalDate today = LocalDate.now();

        LocalDate tomorrow = LocalDate.of(2018, 1, 29);
        if (tomorrow.isAfter(today)) {
            System.out.println("Tomorrow comes after today");
        }

        //减去一天
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if (yesterday.isBefore(today)) {
            System.out.println("Yesterday is day before today");
        }
    }

    /**
     * 获取特定时区下面的时间
     */
    public static void getZoneTime() {
        //设置时区
        ZoneId america = ZoneId.of("America/New_York");

        LocalDateTime localDateAndTime = LocalDateTime.now();

        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localDateAndTime, america);
        System.out.println("现在的日期和时间在特定的时区 : " + dateAndTimeInNewYork);
    }

    /**
     * 使用 YearMonth MonthDay类处理特定的日期
     */
    public static void checkCardExpiry() {
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2028, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);

        MonthDay monthDay = MonthDay.now();
        System.out.printf("Day in month day %s: %d%n", monthDay, monthDay.getDayOfMonth());
    }

    /**
     * 检查闰年
     */
    public static void isLeapYear() {
        LocalDate today = LocalDate.now();
        if (today.isLeapYear()) {
            System.out.println("This year is Leap year");
        } else {
            System.out.println("2018 is not a Leap year");
        }
    }

    /**
     * 计算两个日期之间的天数和月数
     */

    public static void calcDateDays() {
        LocalDate today = LocalDate.now();

        LocalDate java8Release = LocalDate.of(2018, Month.MAY, 14);

        Period periodToNextJavaRelease = Period.between(today, java8Release);

        System.out.println("Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths());
    }

    /**
     * 包含时差信息的日期和时间
     */
    public void ZoneOffset() {
        LocalDateTime datetime = LocalDateTime.of(2018, Month.FEBRUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("Date and Time with timezone offset in Java : " + date);
    }

    /**
     * 获取时间戳
     */
    public static void getTimestamp() {
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
    }

    /**
     * 使用预定义的格式化工具去解析或格式化日期
     */
    public static void formatDate() {
        String dayAfterTomorrow = "20180210";
        LocalDate formatted = LocalDate.parse(dayAfterTomorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTomorrow, formatted);
    }


}


