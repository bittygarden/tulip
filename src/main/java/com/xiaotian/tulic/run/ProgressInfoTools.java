package com.xiaotian.tulic.run;

import java.util.Objects;

/**
 * 进度计算工具类
 *
 * @author sunfeilong
 */
public class ProgressInfoTools {

    private static final String SUFFIX = "%";

    private static String format(long totalWork, long hasFinishedWork, String suffix) {

        double percent = 0;

        if (totalWork != 0 && hasFinishedWork != 0) {
            percent = hasFinishedWork * 1.0 * 100 / totalWork;
        }
        if (Objects.isNull(suffix)) {
            return String.format("%.2f", percent);
        } else {
            return String.format("%.2f%s", percent, suffix);
        }

    }

    public static String format(long totalWork, long hasFinishedWork) {
        return format(totalWork, hasFinishedWork, null);
    }

    public static String format(int totalWork, int hasFinishedWork) {
        return format(((long) totalWork), ((long) hasFinishedWork), null);
    }

    public static String formatWithDefaultSuffix(long totalWork, long hasFinishedWork) {
        return format(totalWork, hasFinishedWork, SUFFIX);
    }

    public static String formatWithDefaultSuffix(int totalWork, int hasFinishedWork) {
        return format(((long) totalWork), ((long) hasFinishedWork), SUFFIX);
    }

    public static String formatWithSuffix(long totalWork, long hasFinishedWork, String suffix) {
        return format(totalWork, hasFinishedWork, suffix);
    }

    public static String formatWithSuffix(int totalWork, int hasFinishedWork, String suffix) {
        return format(((long) totalWork), ((long) hasFinishedWork), suffix);
    }
}
