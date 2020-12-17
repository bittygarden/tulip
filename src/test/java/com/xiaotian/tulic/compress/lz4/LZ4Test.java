package com.xiaotian.tulic.compress.lz4;

import com.xiaotian.tulip.compress.CompressData;
import com.xiaotian.tulip.compress.lz4.LZ4;
import com.xiaotian.tulip.generator.ByteGenerator;
import org.junit.Assert;
import org.junit.Test;

public class LZ4Test {

    private final LZ4 lz4 = new LZ4();


    @Test
    public void compress() {
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

    private void test(int length) {
        CompressData data = CompressData.from(generateData(length));
        CompressData compressData = lz4.compress(data);
        CompressData decompress = lz4.decompress(compressData);
        Assert.assertEquals("压缩或解压缩出错", data.string(), decompress.string());
    }

    private byte[] generateData(int length) {
        return ByteGenerator.bytes(length);
    }
}