package com.xiaotian.tulic.radix;

import com.xiaotian.tulip.progress.ProgressInfoTools;
import com.xiaotian.tulip.radix.NumberBytesConverter;
import org.junit.Assert;
import org.junit.Test;

public class DataByteConverterTest {

    @Test
    public void testByteAndIntConvert() {

        int count = 100000;

        long min = Integer.MIN_VALUE;
        long max = Integer.MAX_VALUE;

        int skip = (int) ((max - min) / count);

        while (true) {
            min = max - min <= skip ? max : min + skip;
            byte[] intToByte = NumberBytesConverter.intToByte(((int) min));
            int byteToInt = NumberBytesConverter.byteToInt(intToByte);
            Assert.assertEquals(min, byteToInt);
            if (min == max) {
                break;
            }
        }
    }

    @Test
    public void testOther() {
        byte[] intToByte = NumberBytesConverter.intToByte(-1);
        int byteToInt = NumberBytesConverter.byteToInt(intToByte);
        Assert.assertEquals(-1, byteToInt);

        intToByte = NumberBytesConverter.intToByte(-2);
        byteToInt = NumberBytesConverter.byteToInt(intToByte);
        Assert.assertEquals(-2, byteToInt);

        intToByte = NumberBytesConverter.intToByte(0);
        byteToInt = NumberBytesConverter.byteToInt(intToByte);
        Assert.assertEquals(0, byteToInt);

        intToByte = NumberBytesConverter.intToByte(1);
        byteToInt = NumberBytesConverter.byteToInt(intToByte);
        Assert.assertEquals(1, byteToInt);
    }
}