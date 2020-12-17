package com.xiaotian.tulip.compress.gzip;

import com.xiaotian.tulip.compress.Compress;
import com.xiaotian.tulip.compress.CompressData;
import com.xiaotian.tulip.compress.Decompress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * gzip 较BZip2 压缩效率低，较 bzip压缩速度快。
 *
 * @author sunfeilong [2020/11/25 17:46]
 */
public class GZip implements Compress, Decompress {

    private static final int KB = 1024;

    private static final int ONE_MB_BYTE = KB << (10 - 3);


    @Override
    public CompressData compress(CompressData data) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
        ) {
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gzipOutputStream.write(data.data());
            gzipOutputStream.close();
            return CompressData.from(byteArrayOutputStream.toByteArray());
        }
    }

    @Override
    public CompressData decompress(CompressData data) throws IOException {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(data.data(), 0, data.length());
             GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream, ONE_MB_BYTE);
             ByteArrayOutputStream temp = new ByteArrayOutputStream()
        ) {
            int readCount;
            byte[] tempByte = new byte[ONE_MB_BYTE];
            while ((readCount = gzipInputStream.read(tempByte)) > 0) {
                temp.write(tempByte, 0, readCount);
            }
            return CompressData.from(temp.toByteArray());
        }
    }

}
