package com.xiaotian.tulip.compress.bzip;

import com.xiaotian.tulip.compress.Compress;
import com.xiaotian.tulip.compress.CompressData;
import com.xiaotian.tulip.compress.Decompress;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Bzip 注重压缩效率
 *
 * @author sunfeilong [2020/11/26 15:51]
 */
public class BZip2 implements Compress, Decompress {

    private static final int KB = 1024;

    private static final int ONE_MB_BYTE = KB << (10 - 3);

    @Override
    public CompressData compress(CompressData data) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
        ) {
            BZip2CompressorOutputStream bZip2CompressorOutputStream = new BZip2CompressorOutputStream(byteArrayOutputStream);
            bZip2CompressorOutputStream.write(data.data());
            bZip2CompressorOutputStream.close();
            return CompressData.from(byteArrayOutputStream.toByteArray());
        }
    }

    @Override
    public CompressData decompress(CompressData data) throws IOException {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(data.data(), 0, data.length());
             BZip2CompressorInputStream bZip2CompressorInputStream = new BZip2CompressorInputStream(inputStream);
             ByteArrayOutputStream temp = new ByteArrayOutputStream()
        ) {
            int readCount;
            byte[] tempByte = new byte[ONE_MB_BYTE];
            while ((readCount = bZip2CompressorInputStream.read(tempByte)) > 0) {
                temp.write(tempByte, 0, readCount);
            }
            return CompressData.from(temp.toByteArray());
        }
    }
}
