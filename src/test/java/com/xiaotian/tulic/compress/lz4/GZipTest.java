package com.xiaotian.tulic.compress.lz4;

import com.xiaotian.tulic.compress.CompressData;
import com.xiaotian.tulic.compress.gzip.GZip;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GZipTest {

    private final GZip gZip = new GZip();


    @Test
    public void compress() throws IOException {
//        test(0);
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
        CompressData compressData = gZip.compress(data);
        CompressData decompress = gZip.decompress(compressData);
        Assert.assertEquals("压缩或解压缩出错", data.string(), decompress.string());
    }

    private byte[] generateData(int length) {
        byte[] bytes = new byte[length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = 'a';
        }
        return bytes;
    }
}