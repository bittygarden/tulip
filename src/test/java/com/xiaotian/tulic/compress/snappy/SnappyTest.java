package com.xiaotian.tulic.compress.snappy;

import com.xiaotian.tulip.compress.CompressData;
import com.xiaotian.tulip.compress.snappy.Snappy;
import com.xiaotian.tulip.generator.ByteGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SnappyTest {

    private final Snappy snappy = new Snappy();

    @Test
    public void compress() throws IOException {
        test(0);
        test(1);
        test(10);
        test(100);
        test(1000);
        test(10000);
        test(100000);
        test(1000000);
        test(10000000);
    }

    private void test(int length) throws IOException {
        CompressData data = CompressData.from(generateData(length));
        CompressData compressData = snappy.compress(data);
        CompressData decompress = snappy.decompress(compressData);
        System.out.println(data.length());
        System.out.println(compressData.length());
        System.out.println();
        System.out.println();
        Assert.assertEquals("压缩或解压缩出错", data.string(), decompress.string());
    }

    private byte[] generateData(int length) {
        return ByteGenerator.bytes(length);
    }
}