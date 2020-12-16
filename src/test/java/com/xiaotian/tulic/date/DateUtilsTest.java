package com.xiaotian.tulic.date;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateUtilsTest {

    @Test
    public void testFormatters() {
        LocalDateTime dateTime = LocalDateTime.of(2020, 12, 12, 12, 12, 12, 0);
        String result = DateUtils.dateUnderlineBlankTimeColon(dateTime);
        Assert.assertEquals("", "2020-12-12 12:12:12", result);

        dateTime = LocalDateTime.of(2020, 12, 12, 12, 12, 0, 0);
        result = DateUtils.dateUnderlineBlankTimeColon(dateTime);
        Assert.assertEquals("", "2020-12-12 12:12:00", result);

        dateTime = LocalDateTime.of(2020, 12, 12, 0, 0, 0, 0);
        result = DateUtils.dateUnderlineBlankTimeColon(dateTime);
        Assert.assertEquals("", "2020-12-12 00:00:00", result);

        LocalDate date = LocalDate.of(2020, 12, 12);
        result = DateUtils.dateUnderlineBlankTimeColon(date);
        Assert.assertEquals("", "2020-12-12", result);

        date = LocalDate.of(2020, 12, 1);
        result = DateUtils.dateUnderlineBlankTimeColon(date);
        Assert.assertEquals("", "2020-12-01", result);

        date = LocalDate.of(2020, 1, 1);
        result = DateUtils.dateUnderlineBlankTimeColon(date);
        Assert.assertEquals("", "2020-01-01", result);

        date = LocalDate.of(0, 1, 1);
        result = DateUtils.dateUnderlineBlankTimeColon(date);
        Assert.assertEquals("", "0000-01-01", result);

        LocalTime time = LocalTime.of(12, 12, 12);
        result = DateUtils.dateUnderlineBlankTimeColon(time);
        Assert.assertEquals("", "12:12:12", result);

        time = LocalTime.of(12, 12, 0);
        result = DateUtils.dateUnderlineBlankTimeColon(time);
        Assert.assertEquals("", "12:12:00", result);

        time = LocalTime.of(12, 0, 0);
        result = DateUtils.dateUnderlineBlankTimeColon(time);
        Assert.assertEquals("", "12:00:00", result);

        time = LocalTime.of(0, 0, 0);
        result = DateUtils.dateUnderlineBlankTimeColon(time);
        Assert.assertEquals("", "00:00:00", result);
    }

}