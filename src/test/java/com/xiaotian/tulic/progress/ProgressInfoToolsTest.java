package com.xiaotian.tulic.progress;

import com.xiaotian.tulip.progress.ProgressInfoTools;
import org.junit.Assert;
import org.junit.Test;

public class ProgressInfoToolsTest {

    @Test
    public void format() {
        String progress = ProgressInfoTools.format(1, 1);
        Assert.assertEquals("100.00", progress);

        progress = ProgressInfoTools.format(0, 1);
        Assert.assertEquals("0.00", progress);

        progress = ProgressInfoTools.format(0, 1);
        Assert.assertEquals("0.00", progress);


        progress = ProgressInfoTools.format(3, 1);
        Assert.assertEquals("33.33", progress);
    }

    @Test
    public void formatLong() {
        String progress = ProgressInfoTools.format(1L, 1L);
        Assert.assertEquals("100.00", progress);

        progress = ProgressInfoTools.format(0L, 1L);
        Assert.assertEquals("0.00", progress);

        progress = ProgressInfoTools.format(0L, 1L);
        Assert.assertEquals("0.00", progress);


        progress = ProgressInfoTools.format(3L, 1L);
        Assert.assertEquals("33.33", progress);
    }

    @Test
    public void formatWithDefaultSuffix() {
        String progress = ProgressInfoTools.formatWithDefaultSuffix(1, 1);
        Assert.assertEquals("100.00%", progress);

        progress = ProgressInfoTools.formatWithDefaultSuffix(0, 1);
        Assert.assertEquals("0.00%", progress);

        progress = ProgressInfoTools.formatWithDefaultSuffix(0, 1);
        Assert.assertEquals("0.00%", progress);
    }

    @Test
    public void formatWithDefaultSuffixLong() {
        String progress = ProgressInfoTools.formatWithDefaultSuffix(1L, 1L);
        Assert.assertEquals("100.00%", progress);

        progress = ProgressInfoTools.formatWithDefaultSuffix(0L, 1L);
        Assert.assertEquals("0.00%", progress);

        progress = ProgressInfoTools.formatWithDefaultSuffix(0L, 1L);
        Assert.assertEquals("0.00%", progress);
    }

    @Test
    public void formatWithSuffix() {
        String progress = ProgressInfoTools.formatWithSuffix(1, 1, " %");
        Assert.assertEquals("100.00 %", progress);

        progress = ProgressInfoTools.formatWithSuffix(0, 1, " %");
        Assert.assertEquals("0.00 %", progress);

        progress = ProgressInfoTools.formatWithSuffix(0, 1, " %");
        Assert.assertEquals("0.00 %", progress);
    }

    @Test
    public void formatWithSuffixLong() {
        String progress = ProgressInfoTools.formatWithSuffix(1L, 1L, " %");
        Assert.assertEquals("100.00 %", progress);

        progress = ProgressInfoTools.formatWithSuffix(0L, 1L, " %");
        Assert.assertEquals("0.00 %", progress);

        progress = ProgressInfoTools.formatWithSuffix(0L, 1L, " %");
        Assert.assertEquals("0.00 %", progress);
    }
}