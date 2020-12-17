package com.xiaotian.tulic.compress.bzip;

import com.xiaotian.tulip.compress.CompressData;
import com.xiaotian.tulip.compress.bzip.BZip2;
import com.xiaotian.tulip.generator.ByteGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class BZip2Test {

    private final BZip2 bZip2 = new BZip2();


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
        CompressData compressData = bZip2.compress(data);
        CompressData decompress = bZip2.decompress(compressData);
        Assert.assertEquals("压缩或解压缩出错", data.string(), decompress.string());
    }

    private byte[] generateData(int length) {
        return ByteGenerator.bytes(length);
    }
}