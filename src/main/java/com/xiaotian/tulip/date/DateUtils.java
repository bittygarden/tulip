package com.xiaotian.tulip.date;

import com.xiaotian.tulip.asserts.Asserts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static java.time.temporal.ChronoField.*;

/**
 * 日期工具类
 *
 * @author sunfeilong [ 2020/12/16 11:53 ]
 */
public class DateUtils {

    /**
     * YYYY-MM-DD HH:MM:SS
     */
    private static final DateTimeFormatter DateUnderlineBlankTimeColon;

    static {
        DateUnderlineBlankTimeColon = new DateTimeFormatterBuilder()
                .optionalStart()
                .appendValue(YEAR, 4)
                .appendLiteral("-")
                .appendValue(MONTH_OF_YEAR, 2)
                .appendLiteral("-")
                .appendValue(DAY_OF_MONTH, 2)
                .appendLiteral(" ")
                .optionalEnd()
                .optionalStart()
                .appendValue(HOUR_OF_DAY, 2)
                .appendLiteral(":")
                .appendValue(MINUTE_OF_HOUR, 2)
                .appendLiteral(":")
                .appendValue(SECOND_OF_MINUTE, 2)
                .optionalEnd()
                .toFormatter();
    }

    public static String dateUnderlineBlankTimeColon(LocalDateTime dateTime) {
        Asserts.assertNotNull(dateTime, "param dateTime must not null");
        return DateUnderlineBlankTimeColon.format(dateTime);
    }

    public static String dateUnderlineBlankTimeColon(LocalDate date) {
        Asserts.assertNotNull(date, "param date must not null");
        return DateUnderlineBlankTimeColon.format(date).trim();
    }

    public static String dateUnderlineBlankTimeColon(LocalTime time) {
        Asserts.assertNotNull(time, "param time must not null");
        return DateUnderlineBlankTimeColon.format(time);
    }
}
